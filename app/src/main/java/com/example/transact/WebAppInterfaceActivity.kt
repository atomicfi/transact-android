package com.example.transact

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Base64
import android.webkit.JavascriptInterface
import androidx.core.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.activity_webview.*
import org.json.JSONObject


class WebAppInterface(private val mContext: Context) {

    @JavascriptInterface
    fun handleAction(data: String) {

        val rawPayload = Base64.decode(data.toByteArray(), Base64.DEFAULT)
        val response = JSONObject(String(rawPayload))
        val action = response.getString("event")
        val url = response.getString("url")

        when(action) {
            "atomic-transact-close" -> closeTransact()
            "atomic-transact-finish" -> finishTransact()
            "atomic-transact-open-url" -> openUrl(url)
        }
    }

    fun closeTransact() {
        (mContext as WebViewActivity).webview_transact?.post {
            (mContext as WebViewActivity).finish()
        }
    }

    fun finishTransact() {
        (mContext as WebViewActivity).webview_transact?.post {
            (mContext as WebViewActivity).finish()
        }
    }

    fun openUrl(url: String) {
        val uris = Uri.parse(url)
        val intents = Intent(Intent.ACTION_VIEW, uris)
        val b = Bundle()
        b.putBoolean("new_window", true)
        intents.putExtras(b)
        mContext.startActivity(intents)
    }
}