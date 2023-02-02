FROM adoptopenjdk/openjdk11:alpine-jre
EXPOSE 8080
ADD  target/springboot-mongodb-crud.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]