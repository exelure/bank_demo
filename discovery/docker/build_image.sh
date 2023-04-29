#!/bin/sh

cd ..
./gradlew clean build
docker build --no-cache -t bank_demo/discovery -f docker/Dockerfile .
