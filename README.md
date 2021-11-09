# Flutter Sound System

Flutter sound recorder and player.

## Getting Started

Currently only working on Android.

## Usage

Android:
```
    // Storage permission
    FlutterSoundSystem.record('path to lovation including file name');

    String filePath = await FlutterSoundSystem.stopRecording();
```