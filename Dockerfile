# FROM amazoncorretto:17.0.3-alpine
# VOLUME /tmp
# EXPOSE 8082
# COPY target/wordcard-api-0.0.1-SNAPSHOT.jar wordcard-api.jar
# ENTRYPOINT ["java","-jar","/wordcard-api.jar"]

# base image to build a JRE
FROM amazoncorretto:17.0.3-alpine as corretto-jdk

# required for strip-debug to work
RUN apk add --no-cache binutils

# Build small JRE image
RUN $JAVA_HOME/bin/jlink \
         --verbose \
         --add-modules ALL-MODULE-PATH \
         --strip-debug \
         --no-man-pages \
         --no-header-files \
         --compress=2 \
         --output /customjre

# main app image
FROM alpine:latest
ENV JAVA_HOME=/jre
ENV PATH="${JAVA_HOME}/bin:${PATH}"

# copy JRE from the base image
COPY --from=corretto-jdk /customjre $JAVA_HOME

# Add app user
ARG APPLICATION_USER=appuser
RUN adduser --no-create-home -u 1000 -D $APPLICATION_USER

# Configure working directory
RUN mkdir /app && \
    chown -R $APPLICATION_USER /app

USER 1000

COPY --chown=1000:1000 target/wordcard-api-0.0.1-SNAPSHOT.jar wordcard-api.jar
WORKDIR /app

EXPOSE 8082
ENTRYPOINT [ "/jre/bin/java", "-jar", "/wordcard-api.jar" ]
