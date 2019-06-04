package org.thoughtcrime.securesms.notifications;

import android.content.Context;
import android.os.Build;

public class MessageNotifierCompat {

    public static final int     NO_VISIBLE_CHAT_ID        = -1;
    static final  int           SUMMARY_NOTIFICATION_ID   = 1338;
    static final  String        EXTRA_REMOTE_REPLY        = "extra_remote_reply";


    private static MessageNotifier instance;

    public static void init(Context context) {
        if (instance != null) {
            return;
        }

        if (Build.VERSION.SDK_INT < 23) {
            instance = new MessageNotifierPreApi23(context);
        } else {
            instance = new MessageNotifierApi23(context);
        }
    }

    public static void playSendSound() {
        instance.playSendSound();
    }

    public static void updateNotification(int chatId, int messageId) {
        instance.updateNotification(chatId, messageId);
    }

    public static void updateVisibleChat(int chatId) {
        instance.updateVisibleChat(chatId);
    }

    public static void onNotificationPrivacyChanged() {
        instance.onNotificationPrivacyChanged();
    }

    static void removeNotifications(int[] chatIds) {
        instance.removeNotifications(chatIds);

    }
    public static void removeNotifications(int chatId) {
        instance.removeNotifications(chatId);
    }


}
