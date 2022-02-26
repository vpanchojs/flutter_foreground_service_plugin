package com.saywut.flutter_foreground_service_plugin;

import android.content.Context;

import androidx.annotation.NonNull;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;

public class FlutterForegroundServicePlugin implements FlutterPlugin
{
  public static final String FOREGROUND_CHANNEL_CHANNEL = "com.saywut.flutter_foreground_service_plugin/foreground_channel";

  private MethodChannel methodChannel;

  @Override
  public void onAttachedToEngine(@NonNull FlutterPluginBinding binding)
  {
    setupChannels(binding.getBinaryMessenger(), binding.getApplicationContext());
  }

  @Override
  public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding)
  {
    teardownChannels();
  }

  private void setupChannels(BinaryMessenger messenger, Context context)
  {
    FlutterForegroundServiceChannelHandler handler = new FlutterForegroundServiceChannelHandler(context);
    if(messenger != null){
      System.out.println("FFSP: Registering method handler");
      methodChannel = new MethodChannel(messenger, FOREGROUND_CHANNEL_CHANNEL);
      methodChannel.setMethodCallHandler(handler);
    }
    
  }

  private void teardownChannels()
  {
    methodChannel.setMethodCallHandler(null);
    methodChannel = null;
  }
}
