FROM eclipse-temurin:17-jdk-alpine
RUN apk add curl
VOLUME /tmp
EXPOSE 8080
ADD target/Test.jar Test.jar
ENTRYPOINT ["java","-jar","/Test.jar"]