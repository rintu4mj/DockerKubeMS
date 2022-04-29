FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} docker-mysql.jar
ENTRYPOINT ["java","-jar","/docker-mysql.jar"]
ENV PORT 8084
EXPOSE 8084