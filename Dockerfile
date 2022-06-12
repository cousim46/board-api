FROM openjdk:11-jdk
LABEL maintainer="wjdghldns24@naver.com"
EXPOSE 8080
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]