FROM openjdk:17
MAINTAINER fvtech.com
COPY build/libs/activity-api-0.0.2-SNAPSHOT.jar activity-service.jar
ENTRYPOINT ["java","-jar","/activity-service.jar"]