
cd ..
./gradlew clean build
docker build -t bank_demo/discovery -f docker/Dockerfile .
