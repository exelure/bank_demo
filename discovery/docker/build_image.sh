#!/bin/sh

IMAGE_NAME=bank_demo/discovery
IMAGE_TAG=1.0.0

cd ..
./gradlew clean build
docker build --no-cache --tag $IMAGE_NAME:$IMAGE_TAG -f docker/Dockerfile .
