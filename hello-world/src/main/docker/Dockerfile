FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
EXPOSE 8880
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]