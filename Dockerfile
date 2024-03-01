# Use an OpenJDK base image
FROM openjdk:11-jre-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/calculator-1.0-SNAPSHOT.jar /app/calculator.jar

