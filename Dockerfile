# Use the official OpenJDK base image
FROM openjdk:11-jre-slim
ADD target/DevOps_Project-2.1.jar devops_project-2.1.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","/devops_project-2.1.jar"]