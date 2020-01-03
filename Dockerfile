FROM java:8
WORKDIR news-portal
ADD /target/rest.jar rest.jar
EXPOSE 8080
CMD java -jar rest.jar