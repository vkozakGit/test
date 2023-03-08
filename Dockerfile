# Use official image of OpenJDK 17 as base image
FROM openjdk:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy the executable jar from the build/libs directory to the app directory
COPY build/libs/myapp.jar .

# Expose the port on which the Spring Boot application will run
EXPOSE 8080

# Set environment variables for MongoDB connection
ENV MONGODB_URI mongodb://mongo:27017/mydb
ENV MONGODB_DATABASE mydb

# Run the application
CMD ["java", "-jar", "myapp.jar"]
