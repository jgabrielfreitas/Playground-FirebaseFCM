package com.jgabrielfreitas.firebase.push.application

import android.app.Application
import android.util.Log
import com.exacttarget.etpushsdk.*
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability
import com.google.firebase.FirebaseApp

/**
 * Created by JGabrielFreitas on 03/05/17.
 */
class FirebasePushApplication : Application() {

  override fun onCreate() {
    super.onCreate()

    FirebaseApp.initializeApp(this)

      Log.d("PushApp", "He")
      try {
          ETPush.configureSdk(ETPushConfig.Builder(this)
                  .setEtAppId("dd598419-2614-4d58-a58a-474c18519995")
                  .setAccessToken("ycjp4dcaaym5a5pv7vb8f4ze")
                  .setGcmSenderId("243143288404")
                  .setAnalyticsEnabled(true)    // ET Analytics, default = false
                  .setWamaEnabled(true)         // Web & Mobile Analytics, default = false
                  .build(), object : ETPushConfigureSdkListener {
              override fun onETPushConfigurationSuccess(etPush: ETPush, etRequestStatus: ETRequestStatus) {
                  Log.d("LOOK", ETPush.getInstance().sdkState)
                  // Verify Google Play Services availability and notify the user of any exceptions
                  if (etRequestStatus.googlePlayServiceStatusCode != ConnectionResult.SUCCESS && GoogleApiAvailability.getInstance().isUserResolvableError(etRequestStatus.googlePlayServiceStatusCode)) {
                      GoogleApiAvailability.getInstance().showErrorNotification(applicationContext, etRequestStatus.googlePlayServiceStatusCode)
                  }
                  // Add attributes, tags, set subscriber key, etc.
                  try {
                      Log.e("LOOK", etPush.attributes.toString())
                      etPush.addAttribute("contact-key", "bd484ef9-27b0-4574-9aef-e3372a6e2c4c")
//                     etPush. = "89480204AC587919CA5253DE8D366317F5B9AC3981D52E852F14AEC8DF3AE94C"
                      etPush.subscriberKey = "bd484ef9-27b0-4574-9aef-e3372a6e2c4c"
                      etPush.updateEt()
                      etPush.disablePush()
                      // etc ...
                  } catch (e: ETException) {
                      Log.e("E", e.message)
                      e.printStackTrace()
                  }

              }

              override fun onETPushConfigurationFailed(e: ETException) {
                  // If we're here then your application will _NOT_ receive push notifications.
                  Log.e("E", e.message)
                  e.printStackTrace()
              }

          }
          )
      } catch (e: ETException) {
          Log.d("D", e.message)
          e.printStackTrace()
      }

  }
}
