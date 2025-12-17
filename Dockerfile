FROM maven:3.9-eclipse-temurin-17 AS build

WORKDIR /build

COPY pom.xml .
COPY src src

RUN mvn package

FROM eclipse-temurin:17-jre-alpine AS runtime

COPY --from=build /build/target/docker-lab-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]