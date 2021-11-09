#import "FlutterSoundSystemPlugin.h"
#if __has_include(<flutter_sound_system/flutter_sound_system-Swift.h>)
#import <flutter_sound_system/flutter_sound_system-Swift.h>
#else
// Support project import fallback if the generated compatibility header
// is not copied when this plugin is created as a library.
// https://forums.swift.org/t/swift-static-libraries-dont-copy-generated-objective-c-header/19816
#import "flutter_sound_system-Swift.h"
#endif

@implementation FlutterSoundSystemPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftFlutterSoundSystemPlugin registerWithRegistrar:registrar];
}
@end
