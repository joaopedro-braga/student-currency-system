FROM openjdk:17-jdk-alpine
VOLUME /tmp
WORKDIR / 
COPY target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Djava.net.preferIPv4Stack=true", "-jar", "/app.jar", "-Dserver.address=0.0.0.0"]