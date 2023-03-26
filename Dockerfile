FROM openjdk:17
MAINTAINER fvtech.com
COPY target/activity-service-0.0.3.jar activity-service.jar
ENTRYPOINT ["java","-jar","/activity-service.jar"]