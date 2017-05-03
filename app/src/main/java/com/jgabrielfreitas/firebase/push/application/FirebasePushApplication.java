package com.jgabrielfreitas.firebase.push.application;

import android.app.Application;
import com.google.firebase.FirebaseApp;

/**
 * Created by JGabrielFreitas on 03/05/17.
 */

public class FirebasePushApplication extends Application {

  @Override public void onCreate() {
    super.onCreate();
    FirebaseApp.initializeApp(this);
  }
}
