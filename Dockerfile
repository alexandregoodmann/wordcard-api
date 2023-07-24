FROM adoptopenjdk/openjdk11:ubi
VOLUME /tmp
EXPOSE 8082
COPY target/wordcard-api-0.0.1-SNAPSHOT.jar wordcard-api.jar
ENTRYPOINT ["java","-jar","/wordcard-api.jar"]
