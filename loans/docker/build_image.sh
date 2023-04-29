#!/bin/sh

cd ..
./gradlew clean build
docker build --no-cache -t bank_demo/loans -f docker/Dockerfile .
