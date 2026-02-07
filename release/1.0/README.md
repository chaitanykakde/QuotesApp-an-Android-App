# QuotesApp Release 1.0.0

This folder contains release outputs for version **1.0.0**.

## Local build command

```bash
scripts/build_release.sh
```

## Expected output

- `release/1.0/quotesapp-1.0.0-unsigned.apk`
- `release/1.0/quotesapp-1.0.0-unsigned.apk.sha256`

## Notes

- Current repository is configured with a GitHub Actions workflow (`.github/workflows/release-1.0.yml`) that builds and publishes release artifacts automatically when tag `v1.0.0` is pushed.
- If you need an installable APK for end users, sign the APK with your release keystore.
