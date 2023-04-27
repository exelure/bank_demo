#!/bin/sh

# TODO: replace with helm upgrade
helm delete prod-deployment
helm install prod-deployment prod-env
