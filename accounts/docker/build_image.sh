#!/bin/sh

cd ..
./gradlew clean build
docker build --no-cache -t bank_demo/accounts -f docker/Dockerfile .
