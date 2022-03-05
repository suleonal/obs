FROM openjdk:11
RUN  mkdir -p /sule
WORKDIR /sule
COPY target/obs_backend-0.0.1-SNAPSHOT.jar ./obs_backend-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/sule/obs_backend-0.0.1-SNAPSHOT.jar"]