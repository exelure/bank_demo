
cd ..
./gradlew clean build
docker build -t bank_demo/cards -f docker/Dockerfile .
