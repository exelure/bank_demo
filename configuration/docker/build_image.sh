#!/bin/sh

IMAGE_NAME=bank_demo/configuration
IMAGE_TAG=1.0.0

cd ..
./gradlew clean build
docker build \
  --no-cache \
  --tag $IMAGE_NAME:$IMAGE_TAG \
  -f docker/Dockerfile \
  --build-arg SSH_CONFIGS_KEY="$(cat ~/.ssh/bank_demo_configs)" \
  --build-arg SSH_KNOWN_HOSTS="$(ssh-keyscan -t rsa github.com)" \
  --build-arg SSH_CONFIGS_HOST_NAME="bank_demo_configs_host" \
  --build-arg SSH_CONFIGS_HOST_VALUE="github.com" \
  --build-arg SSH_CONFIGS_USER="exelure" \
  .
