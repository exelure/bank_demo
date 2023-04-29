#!/bin/sh

cd ..
./gradlew clean build
docker build --no-cache -t bank_demo/gateway -f docker/Dockerfile .
