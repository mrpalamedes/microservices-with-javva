# start with a base image contains java runtime
FROM openjdk:17-jdk-slim

# information about siapa yang maintain the image
# MAINTAINER udah deprecated, diganti dengan LABEL
LABEL "org.opencontainers.image.authors"="mimay"

# copy the packaged jar file into our docker image
COPY target/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar

# command to execute the application
ENTRYPOINT [ "java", "-jar", "accounts-0.0.1-SNAPSHOT.jar" ]