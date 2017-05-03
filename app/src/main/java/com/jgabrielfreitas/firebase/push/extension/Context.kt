package com.jgabrielfreitas.firebase.push.extension

import android.content.Context
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT as short

/**
 * Created by JGabrielFreitas on 03/05/17.
 */

fun Context.toast(message: String, duration: Int = short) = Toast.makeText(this, message, duration).show()