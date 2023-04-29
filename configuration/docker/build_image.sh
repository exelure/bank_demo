#!/bin/sh

cd ..
./gradlew clean build
docker build \
  --no-cache \
  -t bank_demo/configuration \
  -f docker/Dockerfile \
  --build-arg SSH_CONFIGS_KEY="$(cat ~/.ssh/bank_demo_configs)" \
  --build-arg SSH_KNOWN_HOSTS="$(ssh-keyscan -t rsa github.com)" \
  --build-arg SSH_CONFIGS_HOST_NAME="bank_demo_configs_host" \
  --build-arg SSH_CONFIGS_HOST_VALUE="github.com" \
  --build-arg SSH_CONFIGS_USER="exelure" \
  .
