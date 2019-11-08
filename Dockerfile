FROM adoptopenjdk:11-jre-hotspot
RUN mkdir /opt/app
ADD build/libs/TCMS-all-1.0-SNAPSHOT.jar /opt/app/app.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "/opt/app/app.jar" ]
