#!/usr/bin/env bash
set -euo pipefail

REPO_ROOT="$(cd "$(dirname "$0")/.." && pwd)"
cd "$REPO_ROOT"

# Android Gradle Plugin 8.x is most stable with JDK 17.
if [[ -d /root/.local/share/mise/installs/java/17.0.2 ]]; then
  export JAVA_HOME=/root/.local/share/mise/installs/java/17.0.2
  export PATH="$JAVA_HOME/bin:$PATH"
fi

run_build() {
  local cmd="$1"
  echo "Running: $cmd assembleRelease"
  if $cmd assembleRelease; then
    return 0
  fi
  return 1
}

if ! run_build "./gradlew"; then
  echo "gradlew build failed, attempting system Gradle fallback..."
  run_build "gradle"
fi

APK_PATH="app/build/outputs/apk/release/app-release-unsigned.apk"
mkdir -p release/1.0
cp "$APK_PATH" release/1.0/quotesapp-1.0.0-unsigned.apk
sha256sum release/1.0/quotesapp-1.0.0-unsigned.apk > release/1.0/quotesapp-1.0.0-unsigned.apk.sha256

echo "Release APK copied to release/1.0"
