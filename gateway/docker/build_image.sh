
cd ..
./gradlew clean build
docker build -t bank_demo/gateway -f docker/Dockerfile .
