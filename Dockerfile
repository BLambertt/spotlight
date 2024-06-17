FROM openjdk:21
COPY target/*.jar spotlight.jar
ENTRYPOINT ["java","-jar","/spotlight.jar"]