
# base image
FROM openjdk:17-jdk-slim as build

# author metadata
MAINTAINER https://github.com/exelure

# move built artifact into container
COPY ./build/libs/cards*.jar cards.jar

# define how container will run app
ENTRYPOINT ["java", "-jar", "/cards.jar"]
