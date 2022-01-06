#!/bin/sh

IMAGE=quay.io/quarkus/ubi-quarkus-native-image:21.3-java17

./mvnw clean package \
  -e -Dmaven.test.skip=true \
  -Pnative \
  -Dquarkus.native.container-build=true \
  -Dquarkus.native.builder-image=${IMAGE}
