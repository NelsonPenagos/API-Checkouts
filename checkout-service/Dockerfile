FROM openjdk:11
COPY "./target/checkout-service-0.0.1-SNAPSHOT.jar" "checkout-service.jar"
EXPOSE 8090
ENTRYPOINT ["java","-jar","checkout-service.jar"]