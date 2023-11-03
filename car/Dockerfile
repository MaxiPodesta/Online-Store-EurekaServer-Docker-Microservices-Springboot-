FROM  openjdk:17-jdk-slim
ARG JAR_FILE=target/car-0.0.1.jar
COPY ${JAR_FILE} app_car.jar
ENTRYPOINT ["java","-jar","app_car.jar"]