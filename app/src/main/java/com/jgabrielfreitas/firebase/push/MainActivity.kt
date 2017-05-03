package com.jgabrielfreitas.firebase.push

import android.content.ClipData.newPlainText
import android.content.ClipboardManager
import butterknife.OnClick
import com.google.firebase.iid.FirebaseInstanceId
import com.jgabrielfreitas.core.activity.BaseActivity
import com.jgabrielfreitas.firebase.push.extension.toast
import com.jgabrielfreitas.layoutid.annotations.InjectLayout
import android.content.Context.CLIPBOARD_SERVICE as clipboard_service

@InjectLayout(layout = R.layout.activity_main)
class MainActivity : BaseActivity() {

  @OnClick(R.id.copyToClipboardButton) fun copyToClipboard() {

    val clipboard = getSystemService(clipboard_service) as ClipboardManager
    val clip = newPlainText("token API", FirebaseInstanceId.getInstance().token)
    clipboard.primaryClip = clip

    toast("copied: " + FirebaseInstanceId.getInstance().token)
  }
}
