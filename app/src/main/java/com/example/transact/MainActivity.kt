package com.example.transact

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun launchWebView(view: View) {
        val launch = Intent(applicationContext, WebViewActivity::class.java)
        startActivity(launch)
    }
}
