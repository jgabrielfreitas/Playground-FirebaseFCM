package com.jgabrielfreitas.firebase.push.notifications

import android.util.Log
import com.google.android.gms.internal.zzt.TAG
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdService

/**
 * Created by JGabrielFreitas on 03/05/17.
 */

class PushFirebaseInstanceIdService : FirebaseInstanceIdService() {

  override fun onTokenRefresh() {
    super.onTokenRefresh()
    // Get updated InstanceID token.
    val refreshedToken = FirebaseInstanceId.getInstance().token
    Log.wtf(TAG, "Refreshed token: " + refreshedToken!!)
  }
}
