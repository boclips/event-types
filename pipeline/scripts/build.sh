#!/usr/bin/env bash

set -eu

export GRADLE_USER_HOME="$(pwd)/.gradle"

(
cd source
./gradlew build --rerun-tasks --no-daemon
)
