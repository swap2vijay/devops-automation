FROM openjdk:17
EXPOSE 6060
ADD target/devops-integration.jar devops-integration.jar
ENTRYPOINT ["java", "jar","devops-integration.jar"]