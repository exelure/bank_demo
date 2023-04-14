# base image
FROM openjdk:17-jdk-slim as build

ARG SSH_CONFIGS_KEY
ARG SSH_KNOWN_HOSTS
ARG SSH_CONFIGS_HOST_NAME
ARG SSH_CONFIGS_HOST_VALUE
ARG SSH_CONFIGS_USER

RUN mkdir -p /root/.ssh
RUN chmod 0700 /root/.ssh
RUN echo "Host ${SSH_CONFIGS_HOST_NAME}" >> /root/.ssh/config
RUN echo "    HostName ${SSH_CONFIGS_HOST_VALUE}" >> /root/.ssh/config
RUN echo "    User ${SSH_CONFIGS_USER}" >> /root/.ssh/config
RUN echo "    IdentityFile ~/.ssh/id_rsa" >> /root/.ssh/config
RUN echo "${SSH_CONFIGS_KEY}" >> /root/.ssh/id_rsa
RUN echo "${SSH_KNOWN_HOSTS}" >> /root/.ssh/known_hosts
RUN chmod 600 /root/.ssh/id_rsa

# author metadata
MAINTAINER https://github.com/exelure

# move built artifact into container
COPY ./build/libs/configuration*.jar configuration.jar

# define how container will run app
ENTRYPOINT ["java", "-jar", "/configuration.jar"]
