
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