
import 'dart:async';
import 'package:flutter/services.dart';

class FlutterSoundSystem {
  static const MethodChannel _channel = MethodChannel('flutter_sound_system');

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }

  static void startRecording(String audioFileNamedPath) {
    _channel.invokeMethod('startRecording', {"file" : audioFileNamedPath});
  }

  static Future stopRecording() async {
    await _channel.invokeMethod('stopRecording');
  }

  static void playMedia(String audioFileNamedPath) {
    _channel.invokeMethod('playMedia', {"file" : audioFileNamedPath});
  }

  static void pauseMedia() {
    _channel.invokeMethod('pauseMedia');
  }

  static void stopMedia() {
    _channel.invokeMethod('stopMedia');
  }
}