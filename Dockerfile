FROM openjdk
LABEL authors="rodrigo"
WORKDIR /app
COPY target/smartBlock-0.0.1-SNAPSHOT.jar /app/smartBlock.jar
USER postgres
ENTRYPOINT ["java", "-jar", "smartBlock.jar"]