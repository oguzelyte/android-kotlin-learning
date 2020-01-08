package com.example.anothertest

import android.app.Activity
import android.content.Context
import android.widget.Toast
import java.time.Duration

// context is superclass of activity and also is passed to the adapter as a variable, so we can call
// the function in the adapters as well
// duration is default variable but can be overriden if you pass another alue
fun Context.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

fun normalFunction(a: Int = 2) {

}