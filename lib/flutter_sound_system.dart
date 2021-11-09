
import 'dart:async';

import 'package:flutter/services.dart';

class FlutterSoundSystem {
  static const MethodChannel _channel = MethodChannel('flutter_sound_system');

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    if(version == null){
      return '';
    }
    return version;
  }

  static void record(String audioFileNamedPath) {
    _channel.invokeMethod('record');
  }

  static Future<String> stopRecording() async {
    return await _channel.invokeMethod('stopRecording');
  }
}