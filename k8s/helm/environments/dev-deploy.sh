#!/bin/sh

helm delete dev-deployment
helm install dev-deployment dev-env
