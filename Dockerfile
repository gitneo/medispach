FROM openjdk:8

COPY target/medispach-0.0.1-SNAPSHOT.jar medispach-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "jar", "/medispach-0.0.1-SNAPSHOT.jar"]
