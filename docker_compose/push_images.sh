#!/bin/sh


CONFIG_IMG=bank_demo/configuration:1.0.0
DISCOVERY_IMG=bank_demo/discovery:1.0.0
GATEWAY_IMG=bank_demo/gateway:1.1.0
ACCOUNTS_IMG=bank_demo/accounts:1.0.0
CARDS_IMG=bank_demo/cards:1.0.0
LOANS_IMG=bank_demo/loans:1.0.0


GCR_REGION=asia.gcr.io
PROJECT_ID=bank-demo-383910

# to show images in the Google Container Registry (gcr)
#gcloud container images list --repository asia.gcr.io/bank-demo-383910/bank_demo
#gcloud container images list-tags asia.gcr.io/bank-demo-383910/bank_demo/configuration
#gcloud container images list-tags asia.gcr.io/bank-demo-383910/bank_demo/discovery
#gcloud container images list-tags asia.gcr.io/bank-demo-383910/bank_demo/gateway
#gcloud container images list-tags asia.gcr.io/bank-demo-383910/bank_demo/accounts
#gcloud container images list-tags asia.gcr.io/bank-demo-383910/bank_demo/cards
#gcloud container images list-tags asia.gcr.io/bank-demo-383910/bank_demo/loans


docker tag $CONFIG_IMG $GCR_REGION/$PROJECT_ID/$CONFIG_IMG
docker push $GCR_REGION/$PROJECT_ID/$CONFIG_IMG

docker tag $DISCOVERY_IMG $GCR_REGION/$PROJECT_ID/$DISCOVERY_IMG
docker push $GCR_REGION/$PROJECT_ID/$DISCOVERY_IMG

docker tag $GATEWAY_IMG $GCR_REGION/$PROJECT_ID/$GATEWAY_IMG
docker push $GCR_REGION/$PROJECT_ID/$GATEWAY_IMG

docker tag $ACCOUNTS_IMG $GCR_REGION/$PROJECT_ID/$ACCOUNTS_IMG
docker push $GCR_REGION/$PROJECT_ID/$ACCOUNTS_IMG

docker tag $CARDS_IMG $GCR_REGION/$PROJECT_ID/$CARDS_IMG
docker push $GCR_REGION/$PROJECT_ID/$CARDS_IMG

docker tag $LOANS_IMG $GCR_REGION/$PROJECT_ID/$LOANS_IMG
docker push $GCR_REGION/$PROJECT_ID/$LOANS_IMG
