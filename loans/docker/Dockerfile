
# base image
FROM openjdk:17-jdk-slim as build

# author metadata
MAINTAINER https://github.com/exelure

# move built artifact into container
COPY ./build/libs/loans*.jar loans.jar

# define how container will run app
ENTRYPOINT ["java", "-jar", "/loans.jar"]
