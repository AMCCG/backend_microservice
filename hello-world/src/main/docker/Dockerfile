FROM openjdk:21-jdk
VOLUME /tmp
EXPOSE 8001
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]