#!/bin/sh

cd dev-env
helm dependencies build
cd ..

cd prod-env
helm dependencies build
cd ..
