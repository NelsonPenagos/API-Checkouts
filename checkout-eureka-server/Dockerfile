FROM openjdk:11
COPY "./target/checkout-eureka-server-0.0.1-SNAPSHOT.jar" "checkout-eureka-server.jar"
EXPOSE 8761
ENTRYPOINT ["java","-jar","checkout-eureka-server.jar"]