FROM openjdk:11
EXPOSE 8089
WORKDIR /app
RUN apt-get update && apt-get install -y curl
RUN curl -o DevOps_Project-2.1.jar -L "http://192.168.1.114:8081/repository/maven-releases/tn/esprit/DevOps_Project/2.1/DevOps_Project-2.1.jar"
ENTRYPOINT ["java", "-jar", "DevOps_Project-2.1.jar"]