
import '../notification_channel/notification_channel_importance.dart';
import '../notification_channel/notification_channel_lockscreen_visibility.dart';

class NotificationChannelContent {
  /// sets the notification id channel
  final String id;

  /// sets the name text
  /// this will be shown in the phone's notification settings
  final String nameText;

  /// sets the description of the channel
  /// this will be shown in the phone's notification settings
  final String descriptionText;

  /// sets the importance of the channel
  final NotificationChannelImportance importance;

  /// sets the lockscreen visibility
  final NotificationChannelLockscreenVisibility lockscreenVisibility;

  /// used for setting the notification content
  /// for further reading click [here](https://developer.android.com/reference/android/app/NotificationChannel)
  NotificationChannelContent({
    required this.id,
    required this.nameText,
    this.descriptionText = "",
    this.importance = NotificationChannelImportance.defaultIm,
    this.lockscreenVisibility = NotificationChannelLockscreenVisibility.secret,
  });
}
