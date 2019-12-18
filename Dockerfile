FROM jeanblanchard/java:8
MAINTAINER GRAJMURU
WORKDIR /root/
COPY build/libs/*.jar .
COPY src/main/resources/application.docker.properties .
CMD java -Dspring.config.location=application.docker.properties -jar datacaching-0.0.1-SNAPSHOT.jar 


