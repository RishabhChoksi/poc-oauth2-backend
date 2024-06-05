FROM openjdk:17-alpine

EXPOSE 8081

COPY ./target/poc-*.jar root.jar

ENTRYPOINT ["java","-jar","root.jar"]