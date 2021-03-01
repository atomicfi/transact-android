package com.example.transact

import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_webview.*
import android.util.Base64

class WebViewActivity: AppCompatActivity() {

    override fun onCreate(savedInstance: Bundle?) {
        super.onCreate(savedInstance)

        val token=intent.getStringExtra("token")
        val product=intent.getStringExtra("product")
        val demoMode=intent.getBooleanExtra("demoMode", false)
        val color=intent.getStringExtra("color")
        val inSdk=intent.getBooleanExtra("inSdk", true)

        val json = """{"token":"$token", "demoMode":$demoMode, "theme":{"brandColor":"$color"}, "inSdk":"$inSdk"}""".toByteArray()

        val payload = Base64.encodeToString(json, Base64.DEFAULT)


        setContentView(R.layout.activity_webview)
        webview_transact.settings.javaScriptEnabled = true
        webview_transact.settings.domStorageEnabled = true
        webview_transact.addJavascriptInterface(WebAppInterface(this), "TransactEvents")
        webview_transact.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                return super.shouldOverrideUrlLoading(view, request)
            }
        }

        webview_transact.loadUrl("https://transact.atomicfi.com/initialize/$payload")

    }

}