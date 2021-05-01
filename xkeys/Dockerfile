FROM openjdk:8-jre
RUN apt-get update; apt-get install -y netcat
COPY ./target/xkeys_web-0.0.1-SNAPSHOT.jar /app/
COPY ./run.sh /app/
WORKDIR /app
RUN chmod 777 /app/run.sh
EXPOSE 8443
CMD ["/app/run.sh"]