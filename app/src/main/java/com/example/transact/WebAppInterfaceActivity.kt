package com.example.transact

import android.content.Context
import android.webkit.JavascriptInterface
import android.widget.Toast

class WebAppInterface(private val mContext: Context) {

    @JavascriptInterface
    fun handleAction(action: String) {
        if(action == "atomic-transact-close") {
            println("brennen is awesome")
        }
        if(action == "atomic-transact-finish") {
            println("brennen is awesome")
        }
        if(action == "atomic-transact-open-url") {
            println("brennen is awesome")
        }
    }
}