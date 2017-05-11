package ui.notification;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import com.google.firebase.messaging.RemoteMessage;
import java.util.Map;

import static android.app.Notification.DEFAULT_ALL;
import static android.app.PendingIntent.FLAG_UPDATE_CURRENT;
import static android.app.PendingIntent.getActivity;
import static android.content.Context.NOTIFICATION_SERVICE;
import static android.content.Intent.ACTION_VIEW;
import static android.graphics.BitmapFactory.decodeResource;
import static android.net.Uri.parse;
import static android.os.Build.VERSION.SDK_INT;
import static android.os.Build.VERSION_CODES.ECLAIR;
import static android.support.v4.app.NotificationCompat.PRIORITY_DEFAULT;
import static com.jgabrielfreitas.firebase.push.R.drawable.ic_action_stat_reply;
import static com.jgabrielfreitas.firebase.push.R.drawable.ic_stat_playground;
import static com.jgabrielfreitas.firebase.push.R.string.action_reply;

public class PlaygroundNotification {

  private static final String NOTIFICATION_TAG = "Playground";
    private static final String TAG = "push";

    public static void notify(final Context context, RemoteMessage message) {

final Resources res = context.getResources();
    final Bitmap picture = decodeResource(res, ic_stat_playground);
    RemoteMessage.Notification notification = message.getNotification();

    //final String ticker = exampleString;
    final String title = "Portal Stone";
    final String text  = message.getData().get("alert");
    for (Map.Entry<String, String> stringStringEntry : message.getData().entrySet())
      Log.e(NOTIFICATION_TAG, String.format("%s = %s", stringStringEntry.getKey(), stringStringEntry.getValue()));

    final NotificationCompat.Builder builder = new NotificationCompat.Builder(context)

        // Set appropriate defaults for the notification light, sound,
        // and vibration.
        .setDefaults(DEFAULT_ALL)

        // Set required fields, including the small icon, the
        // notification title, and text.
        .setSmallIcon(ic_stat_playground)
        .setContentTitle(title)
        .setContentText(text)

        // All fields below this line are optional.

        // Use a default priority (recognized on devices running Android
        // 4.1 or later)
        .setPriority(PRIORITY_DEFAULT)

        // Provide a large icon, shown with the notification in the
        // notification drawer on devices running Android 3.0 or later.
        .setLargeIcon(picture)

        // Set ticker text (preview) information for this notification.
        .setTicker(text)

        // Set the pending intent to be initiated when the user touches
        // the notification.
        .setContentIntent(getActivity(context, 0, new Intent(ACTION_VIEW, parse("http://www.google.com")), FLAG_UPDATE_CURRENT))

        // Example additional actions for this notification. These will
        // only show on devices running Android 4.1 or later, so you
        // should ensure that the activity in this notification's
        // content intent provides access to the same actions in
        // another way.
        .addAction(ic_action_stat_reply, res.getString(action_reply), null)

        // Automatically dismiss the notification when it is touched.
        .setAutoCancel(true);

    notify(context, builder.build());
  }

  @TargetApi(ECLAIR) private static void notify(final Context context, final Notification notification) {
    final NotificationManager nm = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
    if (SDK_INT >= ECLAIR) {
      nm.notify(NOTIFICATION_TAG, 0, notification);
    } else {
      nm.notify(NOTIFICATION_TAG.hashCode(), notification);
    }
  }

  @TargetApi(ECLAIR) public static void cancel(final Context context) {
    final NotificationManager nm = (NotificationManager) context.getSystemService(
        NOTIFICATION_SERVICE);
    if (SDK_INT >= ECLAIR) {
      nm.cancel(NOTIFICATION_TAG, 0);
    } else {
      nm.cancel(NOTIFICATION_TAG.hashCode());
    }
  }
}
