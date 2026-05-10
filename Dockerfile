from eclipse-temurin:17-jdk
workdir /app
copy target/*.jar app.jar
expose 8080
entrypoint ["java", "-jar", "app.jar"]