#!/bin/sh

helm delete prod-deployment
helm install prod-deployment prod-env
