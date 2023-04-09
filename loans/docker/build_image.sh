
cd ..
./gradlew clean build
docker build -t bank_demo/loans -f docker/Dockerfile .
