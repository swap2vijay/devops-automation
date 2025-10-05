FROM openjdk:17
EXPOSE 8080
ADD target/springboot-rest-api.jar springboot-rest-api.jar
ENTRYPOINT ["java", "-jar", "/springboot-rest-api.jar"]
