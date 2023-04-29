#!/bin/sh

cd ..
./gradlew clean build
docker build --no-cache -t bank_demo/cards -f docker/Dockerfile .
