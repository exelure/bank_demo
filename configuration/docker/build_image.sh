
cd ..
./gradlew clean build
docker build -t bank_demo/configuration -f docker/Dockerfile .
