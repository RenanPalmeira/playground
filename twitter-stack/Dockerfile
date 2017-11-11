FROM java:8

ENV TWITTER_ADMIN_PORT 9999
ENV PORT 8080

RUN mkdir /app
ADD target/scala-2.12  /app

CMD ["java", "-jar", "/app/twitter-stack-assembly-1.0.jar", "-admin.port=:9999", "-http.port=:8080"]