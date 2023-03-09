# Base image
FROM gradle:7-jdk17 as builder

# Copy the source code to the image
COPY . /home/gradle/src

# Set working directory
WORKDIR /home/gradle/src

# Build the application
RUN gradle clean build -x test --no-daemon

# Use official image of OpenJDK 17 as base image
FROM openjdk:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy the built JAR file to the image
COPY --from=builder /home/gradle/src/build/libs/myapp.jar myapp.jar

# Expose the port on which the Spring Boot application will run
EXPOSE 8080

# Set environment variables for MongoDB connection
ENV MONGODB_URI mongodb://mongo:27017/mydb
ENV MONGODB_DATABASE mydb

# Run the application
ENTRYPOINT ["java", "-jar", "myapp.jar"]
