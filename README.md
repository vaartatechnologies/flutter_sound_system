# Flutter Sound System

Flutter sound recorder and player.

## Getting Started

Currently only working on Android.

## Usage

Android:
```
    FlutterSoundSystem.record('File Path');
    String filePath = await FlutterSoundSystem.stopRecording();

    FlutterSoundSystem.play('File Path');
    FlutterSoundSystem.stopPlaying();
    FlutterSoundSystem.pausePlaying();
```