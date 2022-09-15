FROM openjdk:jdk

RUN mkdir /docEnv

VOLUME /docEnv

ADD ./target/CritterCutsBackend-0.0.1-SNAPSHOT.jar /docEnv

ENTRYPOINT ["java", "-jar", "./docEnv/CritterCutsBackend-0.0.1-SNAPSHOT.jar"]