FROM azul/zulu-openjdk:11.0.10

RUN apt update

ARG DEPENDENCY=./target/dependency-docker
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
#COPY target/ms-account-0.0.1-SNAPSHOT.jar ms-account-0.0.1.jar

ENV SPRING_PROFILE local
ENV SERVER_PORT 9092
ENV EUREKA_URI http://localhost:8761/eureka

ENTRYPOINT [ "java", \,"-cp","app:app/lib/*","/arquitectura.software.msaccount.MsAccountApplication" ]