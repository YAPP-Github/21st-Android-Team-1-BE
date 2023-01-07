FROM openjdk:17

EXPOSE 8080

# The application's jar file
ARG JAR_FILE=build/libs/buddycon-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} buddycon.jar

# Run the jar file
ENTRYPOINT ["java", "-jar", "/buddycon.jar"]
