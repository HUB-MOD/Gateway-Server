FROM openjdk:8-jdk-alpine
ADD target/*.jar /usr/share/gateway-server.jar
EXPOSE 9020
ENTRYPOINT ["java", "-jar", "/usr/share/gateway-server.jar"]