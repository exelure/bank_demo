
cd ..
./gradlew clean build
docker build -t bank_demo/accounts -f docker/Dockerfile .
