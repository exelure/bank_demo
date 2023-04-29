#!/bin/sh

OLD_JAVA_HOME=$JAVA_HOME
JAVA_HOME="${OLD_JAVA_HOME}/../corretto-17.0.6"

cd ../

cd configuration/docker
./build_image.sh
cd ../..

cd discovery/docker
./build_image.sh
cd ../..

cd gateway/docker
./build_image.sh
cd ../..

cd accounts/docker
./build_image.sh
cd ../..

cd cards/docker
./build_image.sh
cd ../..

cd loans/docker
./build_image.sh
cd ../..


JAVA_HOME=$OLD_JAVA_HOME
