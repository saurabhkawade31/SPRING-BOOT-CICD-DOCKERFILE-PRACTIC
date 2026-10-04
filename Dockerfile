FROM eclipse-temurin:21-jdk

WORKDIR /src

COPY . .

RUN chmod +x mvnw

RUN ./mvnw clean package -DskipTests

LABEL maintainer="saurabhkawade"

CMD ["java", "-jar", "target/example-0.0.1-SNAPSHOT.jar"]
