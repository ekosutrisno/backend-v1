FROM adoptopenjdk/openjdk11:jdk-11.0.8_10-alpine

EXPOSE 8090:8090

COPY /target/xsisapp-api-service.jar /app/application.jar

CMD ["java", "-jar", "/app/application.jar"]