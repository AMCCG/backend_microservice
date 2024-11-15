FROM openjdk:21-jdk
VOLUME /tmp
ARG PORT
ENV EUREKA_SERVER_PORT=$PORT
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]