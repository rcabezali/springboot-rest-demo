#!/bin/bash

# Build app
mvn clean package

# Iniciate app
java -jar -Dspring.profiles.active=dev -Dspring.config.location=springboot-rest-demo.yml springboot-rest-demo-ws/target/springboot-rest-demo-ws-1.0.0-SNAPSHOT.jar
