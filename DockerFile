# Use official OpenJDK base image
FROM openjdk:17-jdk-slim

# Set working directory inside the container
WORKDIR /app

# Copy the JAR file from target folder into the container
COPY target/agastya-builder-1.0.0.jar app.jar

# Expose port (match your application.properties)
EXPOSE 8085

# Run the JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
