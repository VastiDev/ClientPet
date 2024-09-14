FROM openjdk:11-jdk

LABEL authors="Vastiane"

COPY target/cliente-pet-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]

