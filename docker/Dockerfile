FROM openjdk:8-jre
WORKDIR /rating-app
VOLUME ["/rating-app"]
COPY maven/rating-app.jar rating-app.jar
COPY maven/start.sh start.sh
COPY maven/wait-for-it.sh wait-for-it.sh
RUN sh -c 'touch rating-app.jar'
ENTRYPOINT ["./start.sh"]
