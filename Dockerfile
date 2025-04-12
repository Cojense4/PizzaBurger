# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim AS build

# Set the working directory
WORKDIR /app

# Copy the Maven project descriptor file
COPY pom.xml .

# Download the dependencies
RUN apt-get update && apt-get install -y maven && mvn dependency:go-offline

# Copy the project source code
COPY src ./src

# Build the application
RUN mvn package -DskipTests

# Use a minimal runtime image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the built application from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]