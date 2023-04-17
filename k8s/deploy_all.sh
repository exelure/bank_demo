#!/bin/sh

GCR_REGION=asia.gcr.io
PROJECT_ID=bank-demo-383910

docker tag bank_demo/configuration $GCR_REGION/$PROJECT_ID/bank_demo/configuration:latest
docker tag bank_demo/discovery $GCR_REGION/$PROJECT_ID/bank_demo/discovery:latest
docker tag bank_demo/gateway $GCR_REGION/$PROJECT_ID/bank_demo/gateway:latest
docker tag bank_demo/accounts $GCR_REGION/$PROJECT_ID/bank_demo/accounts:latest
docker tag bank_demo/cards $GCR_REGION/$PROJECT_ID/bank_demo/cards:latest
docker tag bank_demo/loans $GCR_REGION/$PROJECT_ID/bank_demo/loans:latest

docker push $GCR_REGION/$PROJECT_ID/bank_demo/configuration:latest
docker push $GCR_REGION/$PROJECT_ID/bank_demo/discovery:latest
docker push $GCR_REGION/$PROJECT_ID/bank_demo/gateway:latest
docker push $GCR_REGION/$PROJECT_ID/bank_demo/accounts:latest
docker push $GCR_REGION/$PROJECT_ID/bank_demo/cards:latest
docker push $GCR_REGION/$PROJECT_ID/bank_demo/loans:latest
