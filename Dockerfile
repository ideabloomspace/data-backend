# Use a base image with Java 11
FROM adoptopenjdk:11-jre-hotspot

# Set the working directory
WORKDIR /app
# Copy the JAR file to the container
COPY  /build/libs/*.jar Kendra-0.0.1-SNAPSHOT-plain.jar
# Expose the port that your Spring Boot application listens on (default is 8080)
EXPOSE 8080
# Define the command to run your application
CMD ["java", "-jar", "Kendra-0.0.1-SNAPSHOT-plain.jar"]