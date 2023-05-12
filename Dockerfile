# Use an OpenJDK base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /tennis-api

# Copy the JAR file into the container
COPY target/tennis-api.jar tennis-api.jar

# Expose the port your application listens on (if needed)
EXPOSE 8080

# Set the command to run your application
CMD ["java", "-jar", "tennis-api.jar"]