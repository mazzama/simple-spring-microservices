FROM openjdk:8-jre-alpine

ADD target/orderservice-0.0.1-SNAPSHOT.jar /opt/mazzama/orderservice-0.0.1-SNAPSHOT.jar
#ADD application-docker.properties /config/application-docker.properties

EXPOSE 8080 8080

ENTRYPOINT [ "java", "-jar", "/opt/mazzama/orderservice-0.0.1-SNAPSHOT.jar" ]
