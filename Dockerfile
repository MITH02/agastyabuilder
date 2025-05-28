# Stage 1: Build the project using Maven
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app

# Copy only pom.xml first to cache dependencies
COPY pom.xml .

# Download dependencies first
RUN mvn dependency:go-offline -B

# Now copy the source code
COPY src ./src

# Build the application (skip tests for speed)
RUN mvn clean package -DskipTests

# Stage 2: Run the app with OpenJDK
FROM openjdk:17-jdk-slim
WORKDIR /app

# Explicitly copy the main application JAR to avoid wildcard issues
COPY --from=builder /app/target/agastya-builder-1.0.0.jar app.jar

# Expose port as per your application.properties
EXPOSE 8085

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
