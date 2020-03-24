package com.example.transact

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun launchWebView(view: View) {
        val launch = Intent(applicationContext, WebViewActivity::class.java)
        launch.putExtra("token", "")
        launch.putExtra("product", "xdeposit")
        launch.putExtra("demoMode",  true)
        launch.putExtra("color",  "#4B39EF")
        startActivity(launch)
    }
}
