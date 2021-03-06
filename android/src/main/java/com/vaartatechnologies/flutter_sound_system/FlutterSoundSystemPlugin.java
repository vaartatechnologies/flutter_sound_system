package com.vaartatechnologies.flutter_sound_system;

import android.app.Activity;
import android.content.Context;

import androidx.annotation.NonNull;

import com.vaartatechnologies.flutter_sound_system.includes.Helper;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;

/** FlutterSoundSystemPlugin */
public class FlutterSoundSystemPlugin implements FlutterPlugin, MethodCallHandler, ActivityAware {
  /// The MethodChannel that will the communication between Flutter and native Android
  ///
  /// This local reference serves to register the plugin with the Flutter Engine and unregister it
  /// when the Flutter Engine is detached from the Activity
  private MethodChannel channel;
  private Context context;
  private Activity activity;

  @Override
  public void onAttachedToEngine(@NonNull FlutterPluginBinding flutterPluginBinding) {
    channel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "flutter_sound_system");
    channel.setMethodCallHandler(this);
  }

  @Override
  public void onMethodCall(@NonNull MethodCall call, @NonNull Result result) {
    if (call.method.equals("getPlatformVersion")) {
      result.success("Android " + android.os.Build.VERSION.RELEASE);
    } else if (call.method.equals("startRecording")) {
      Helper.startRecording(call.argument("file"));
    } else if (call.method.equals("stopRecording")) {
      Helper.stopRecording();
    } else if (call.method.equals("playMedia")) {
      Helper.playMedia(call.argument("file"));
    } else if (call.method.equals("pauseMedia")) {
      Helper.pauseMedia();
    } else if (call.method.equals("stopMedia")) {
      Helper.stopMedia();
    } else {
      result.notImplemented();
    }
  }

  @Override
  public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
    channel.setMethodCallHandler(null);
  }

  // ActivityAware Starts

  @Override
  public void onAttachedToActivity(@NonNull ActivityPluginBinding binding) {
    this.context = binding.getActivity().getApplicationContext();
    this.activity = binding.getActivity();
  }

  @Override
  public void onDetachedFromActivityForConfigChanges() {
    this.context = null;
    this.activity = null;
  }

  @Override
  public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding binding) {
    this.context = binding.getActivity().getApplicationContext();
    this.activity = binding.getActivity();
  }

  @Override
  public void onDetachedFromActivity() {
    this.context = null;
    this.activity = null;
  }

  // ActivityAware Ends
}
