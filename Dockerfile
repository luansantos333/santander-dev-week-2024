FROM openjdk:17
ADD ./docker-santander-dev-week-2024.jar docker-santander-dev-week-2024.jar
ENTRYPOINT ["java", "-jar", "docker-santander-dev-week-2024.jar"]