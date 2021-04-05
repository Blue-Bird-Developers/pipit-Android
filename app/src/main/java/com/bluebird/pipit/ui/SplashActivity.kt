package com.bluebird.pipit.ui

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bluebird.pipit.ui.login.LoginMainActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        while (true) {
            if (checkInternetConnection()){
                startLoginMain()
                break
            }
        }
    }

    private fun checkInternetConnection() : Boolean{
        val cm = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val capabilities = cm.getNetworkCapabilities(cm.activeNetwork)
        return capabilities != null
    }

    private fun startLoginMain(){
        val intent = Intent(this, LoginMainActivity::class.java)
        startActivity(intent)
        finish()
    }
}