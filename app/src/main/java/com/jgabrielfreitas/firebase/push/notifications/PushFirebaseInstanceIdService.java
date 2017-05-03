package com.jgabrielfreitas.firebase.push.notifications;

import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import static com.google.android.gms.internal.zzt.TAG;

/**
 * Created by JGabrielFreitas on 03/05/17.
 */

public class PushFirebaseInstanceIdService extends FirebaseInstanceIdService {

  @Override public void onTokenRefresh() {
    super.onTokenRefresh();
    // Get updated InstanceID token.
    String refreshedToken = FirebaseInstanceId.getInstance().getToken();
    Log.wtf(TAG, "Refreshed token: " + refreshedToken);
  }
}
