FROM eclipse-temurin:17-alpine

WORKDIR /app

COPY target/Week11Example-0.0.1-SNAPSHOT.jar /app

EXPOSE 8080

CMD ["java", "-jar", "Week11Example-0.0.1-SNAPSHOT.jar"]