FROM amazoncorretto:21-alpine3.21
ARG USER_HOME_DIR="/root"
ARG MAVEN_VERSION=3.9.10
ARG BASE_URL=https://downloads.apache.org/maven/maven-3/${MAVEN_VERSION}/binaries

# Install maven and inotify tools
RUN apk add --no-cache curl tar gzip unzip git inotify-tools && \
    mkdir -p /usr/share/maven /usr/share/maven/ref && \
    curl -fsSL -o /tmp/apache-maven.tar.gz ${BASE_URL}/apache-maven-${MAVEN_VERSION}-bin.tar.gz && \
    tar -xzf /tmp/apache-maven.tar.gz -C /usr/share/maven --strip-components=1 && \
    rm -f /tmp/apache-maven.tar.gz && \
    ln -s /usr/share/maven/bin/mvn /usr/bin/mvn

WORKDIR /app
COPY pom.xml pom.xml
COPY src src
COPY entrypoint.sh entrypoint.sh

# Make the script executable
RUN chmod +x ./entrypoint.sh
#
## Set the entrypoint to the script
ENTRYPOINT ["./entrypoint.sh"]
