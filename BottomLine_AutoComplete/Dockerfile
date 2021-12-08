FROM openjdk:11-slim-buster
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} auto-complete-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/auto-complete-0.0.1-SNAPSHOT.jar"]