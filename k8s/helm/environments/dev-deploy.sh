#!/bin/sh

# TODO: replace with helm upgrade
helm delete dev-deployment
helm install dev-deployment dev-env
