#!/bin/sh
set -e # exit on any command failure

WATCH_DIR="/app/src"
BUILD_CMD="mvn compile"
echo "Watching $WATCH_DIR for changes to recompile..."

# Watch for changes and trigger compilation
#- m monitor
#-r recursively
#-e events
inotifywait -m -r -e modify,create,delete,move "$WATCH_DIR" --format '%w%f' | while read FILE
do
    echo "Detected change in: $FILE"
    echo "Recompiling..."
    # compiling so that the classpaths inside target folders changes
    # which makes the spring-devtools restart the server
    $BUILD_CMD
done &
WATCHER_PID=$!

# Run spring boot application
mvn spring-boot:run \
    -Dspring-boot.run.jvmArguments="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005"

# Cleanup background watcher when the main process exits
kill $WATCHER_PID 2>/dev/null
