package com.jgabrielfreitas.firebase.push.notifications

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import ui.notification.PlaygroundNotification

/**
 * Created by JGabrielFreitas on 03/05/17.
 */

class PushMessagingService : FirebaseMessagingService() {

  override fun onMessageReceived(remoteMessage: RemoteMessage?) {
    super.onMessageReceived(remoteMessage)

    PlaygroundNotification.notify(this, remoteMessage)
  }
}
