package com.jgabrielfreitas.firebase.push.notifications;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import ui.notification.PlaygroundNotification;

/**
 * Created by JGabrielFreitas on 03/05/17.
 */

public class PushMessagingService extends FirebaseMessagingService {

  @Override public void onMessageReceived(RemoteMessage remoteMessage) {
    super.onMessageReceived(remoteMessage);

    PlaygroundNotification.notify(this, remoteMessage);
  }
}
