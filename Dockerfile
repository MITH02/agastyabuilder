# Stage 1: Build the project using Maven
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run the app with OpenJDK
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy the built JAR from the builder stage (using wildcard to avoid version issues)
COPY --from=builder /app/target/*.jar app.jar

# Expose your app port (match application.properties)
EXPOSE 8085

# Run the JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
