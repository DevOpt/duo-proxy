FROM openjdk:8-jdk-alpine
COPY ./src/Pingfederate.java /usr/src/pingfederate/
WORKDIR /usr/src/pingfederate/
RUN javac Pingfederate.java
EXPOSE 3000
CMD ["java", "Pingfederate"]