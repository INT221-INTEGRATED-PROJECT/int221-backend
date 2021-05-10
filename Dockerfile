FROM maven:3.6.0-jdk-11-slim AS build
WORKDIR /luxcars
COPY src ./src
COPY pom.xml ./
RUN mvn clean install

FROM adoptopenjdk/openjdk11:jdk-11.0.10_9-alpine
ARG JAR_FILE=/luxcars/target/demo-0.0.1-SNAPSHOT.jar
COPY --from=build ${JAR_FILE} demo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","demo-0.0.1-SNAPSHOT.jar"]