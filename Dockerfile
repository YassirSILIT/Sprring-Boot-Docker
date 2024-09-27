FROM maven:3.9.9-amazoncorretto

WORKDIR /app

COPY . .

RUN mvn clean package

FROM openjdk:24-slim-bookworm

WORKDIR /app

ARG JAR_FILE=target/*jar

COPY ${JAR_FILE} /app/carApp.jar

ENTRYPOINT ["java", "-jar", "/app/carApp.jar"]