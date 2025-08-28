#!/bin/bash
set -e # exit on any command failure

WATCH_DIR="src"

BUILD_CMD_INIT="./mvnw -Dmaven.compiler.useIncrementalCompilation=true -o compile dependency:copy-dependencies"
BUILD_CMD="./mvnw -Dmaven.compiler.useIncrementalCompilation=true -o compile"

SYS_OS=""
WATCHER_PID=""

cleanup(){
    if [[ -n "${WATCHER_PID:-}" ]]; then
      echo "stopping fswatch"
      kill "$WATCHER_PID" 2>/dev/null || true
    fi
}
trap cleanup EXIT SIGINT SIGTERM

install_fswatch(){
  if ! command -v fswatch > /dev/null 2>&1; then
    if command -v brew > /dev/null 2>&1; then
      echo "installing fswatch..."
      brew install fswatch
    else
      echo "brew not found. install brew."
    fi
  else
    echo "fswatch already installed"
  fi
}

check_system_requirements(){
  echo "checking system..."
  if ! SYS_OS="$(uname -s 2>/dev/null)"; then
    echo "failed to detect os"
    exit 1
  fi

  if [ -z "$SYS_OS" ]; then
    echo "failed to detect os"
    exit 1
  fi

  case "$SYS_OS" in
    Darwin)
      install_fswatch
      ;;
    *)
      echo "unsupported os: $SYS_OS"
      exit 1
      ;;
  esac
}

watch_file_changes_with_fswatch(){
  echo "Watching $WATCH_DIR for changes to recompile..."

  fswatch --event-flags -r "$WATCH_DIR" | while read -r full_output; do
#    ignore temp files from ide
    if ! echo "$full_output" | grep -q '~[[:space:]]'; then
      file_path=$(echo "$full_output" | cut -d' ' -f1)
#      events=$(echo "$full_output" | cut -d' ' -f2-)
#      dir=$(dirname "$file_path")
      file=$(basename "$file_path")
#      echo "events: $events"
#      echo "dir: $dir"
      echo "Detected change in file $file"
      echo "Recompiling..."
      # compiling so that the class paths inside target folders changes
      # which makes the spring-devtools restart the server
      $BUILD_CMD
    fi
  done &
  WATCHER_PID=$!
}

################################
main(){
  check_system_requirements

  $BUILD_CMD_INIT

  case "$SYS_OS" in
      Darwin)
        watch_file_changes_with_fswatch
        ;;
      *)
        echo "unsupported os: $SYS_OS"
        exit 1
        ;;
  esac

  docker compose -f docker-compose.yaml up --build
}

################################
main


