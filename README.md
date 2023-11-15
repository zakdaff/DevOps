# ZAK
# DevOps
This document provides an overview of the continuous integration and deployment pipeline for the project.

## Pipeline Stages

### 1. Checkout

Fetches the source code from the `ZAK` branch of the GitHub repository using GitSCM.

### 2. Compile Spring Boot Project

Compiles the Spring Boot project using Maven with clean and package goals.

### 3. Junit/Mockito

Executes JUnit and Mockito tests to ensure code functionality and reliability.

### 4. SonarQube Analysis

Conducts static code analysis using SonarQube by running Maven with SonarQube credentials.

### 5. Nexus

Deploys artifacts to Nexus repository using Maven, skipping tests during deployment.

### 6. Docker Build Image

Builds a Docker image for the application, tagging it with the build number.

### 7. Docker Login

Logs into Docker Hub using provided credentials before pushing the Docker image.

### 8. Docker Push

Pushes the Docker image with the specified tag to Docker Hub.

### 9. Docker Compose

Checks out the Docker Compose file and deploys containers using Docker Compose.

### 10. Start Monitoring

Starts monitoring services in Docker containers using Docker commands.

## Post Actions

- **Always:** Logs out of Docker after pipeline execution.
- **Success:** Sends a success email with a link to access the application and monitoring services.
- **Failure:** Sends a failure email with a request to check Jenkins logs for details.

## Usage

To run the pipeline, follow these steps:

1. Trigger the pipeline in your CI/CD environment.
2. Monitor the progress through each stage.
3. Check the email notifications for success or failure.

## Additional Information
## zakaria.dafdouf@esprit.tn
For more details on each stage, refer to the relevant documentation in the project repository.

---

Feel free to <img width="1280" alt="pipeline" src="https://github.com/zakdaff/DevOps/assets/74161244/38c5ea37-f706-4344-96c1-8ee51a7c6390">
# Testing Supplier in Front End Angular

![ezgif com-optimize](https://github.com/zakdaff/DevOps/assets/74161244/584fbb67-5d4e-4b7c-a2e2-e98add9f8ed0)
