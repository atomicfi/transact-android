package com.example.transact

import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_webview.*

class WebViewActivity: AppCompatActivity() {

    override fun onCreate(savedInstance: Bundle?) {
        super.onCreate(savedInstance)

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

//        webview_transact.loadUrl("https://transact-staging.atomicfi.com/xdeposit/start/eyJwcm9kdWN0IjoieGRlcG9zaXQiLCJkZW1vTW9kZSI6InRydWUiLCJpblNkayI6InRydWUifQ==")
        webview_transact.loadUrl("http://192.168.0.24:4545/xdeposit/start/eyJwcm9kdWN0IjoieGRlcG9zaXQiLCJkZW1vTW9kZSI6InRydWUiLCJpblNkayI6InRydWUifQ==")
    }


}