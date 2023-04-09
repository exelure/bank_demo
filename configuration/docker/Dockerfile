
# base image
FROM openjdk:11-slim as build

# author metadata
MAINTAINER https://github.com/exelure

# move built artifact into container
COPY ./build/libs/configuration*.jar configuration.jar

# define how container will run app
ENTRYPOINT ["java", "-jar", "/configuration.jar"]
