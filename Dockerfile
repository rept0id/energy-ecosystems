# Use an official Gradle image with JDK 17 as the base image
FROM gradle:7.4-jdk17 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the Gradle build files (build.gradle and settings.gradle) into the container
COPY build.gradle .
COPY settings.gradle .

# Copy the entire project source code into the container
COPY src ./src

# Build the project and create the JAR file
RUN gradle clean build

# Create a new stage with a minimal JRE image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the build stage into this new stage
COPY --from=build /app/build/libs/lets-java-backend-spring-boot-0.0.1-SNAPSHOT.jar ./app.jar

# Specify the command to run your Spring Boot application
CMD ["java", "-jar", "app.jar"]

