# OpenJarvis Android

Android adaptation workspace for the OpenJarvis project.

## Current status

This repository currently contains the **first native Android application shell** and a GitHub Actions workflow that builds a debug APK.

It is **not yet the complete OpenJarvis AI runtime**. The upstream OpenJarvis project is a Python/local-first desktop-oriented framework; the supplied source archive does not contain an Android Gradle application. Android support therefore requires a real port/integration effort.

## Build

Open the repository's **Actions** tab and run **Build Android APK**, or push a commit to the `main` branch.

When the workflow succeeds, open its run, then download the artifact named `OpenJarvis-Android-debug`. The APK is inside the downloaded ZIP.

## Offline and device support

The initial shell makes no network requests and does not include a model. Offline AI inference, model management, voice, and the upstream OpenJarvis capabilities are not implemented yet.

The target is ARM64 Android. Runtime and model choices must be tested against actual device memory and Android compatibility before claiming support.

## Planned engineering stages

1. Native Android foundation and reproducible APK build.
2. Select and integrate a compatible on-device inference runtime.
3. Add local model installation/import and storage management.
4. Implement chat, conversation history, and offline tools.
5. Evaluate performance and reliability on physical ARM64 devices.
6. Port additional OpenJarvis capabilities only where Android-compatible.

## Upstream project

https://github.com/open-jarvis/open-jarvis

Respect the upstream project's license and notices when porting or reusing its code.
