# ---------- Stage 1: Build the JAR file ----------
# Use a Maven image with JDK 17 to build the project
FROM maven:3.9.9-eclipse-temurin-17 AS builder

# Set working directory inside the container
WORKDIR /app

# Copy Maven configuration file (pom.xml) to download dependencies
COPY pom.xml .

# Download all dependencies required for the project to speed up builds
RUN mvn dependency:go-offline -B

# Copy the source code into the container
COPY src ./src

# Clean old builds and package the application into a JAR file
RUN mvn clean package


# ---------- Stage 2: Run the Application ----------
# Use a lightweight OpenJDK 17 image to run the built JAR file
FROM openjdk:17-jdk AS runner

# Set working directory for runtime container
WORKDIR /app

# Copy the built JAR file from the builder stage to this runtime container
COPY --from=builder ./app/target/patient-service-0.0.1-SNAPSHOT.jar ./app.jar

# Expose port 4000 so the app can be accessed from outside
EXPOSE 4000

# Command to start the application
ENTRYPOINT ["java", "-jar", "app.jar"]