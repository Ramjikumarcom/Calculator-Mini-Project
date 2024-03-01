# Use an OpenJDK base image
FROM openjdk:17-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/calculator-1.0-SNAPSHOT.jar /app/calculator.jar

