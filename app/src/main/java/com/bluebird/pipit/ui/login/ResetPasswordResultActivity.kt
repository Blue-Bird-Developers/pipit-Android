package com.bluebird.pipit.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bluebird.pipit.R
import kotlinx.android.synthetic.main.activity_reset_password_result.*

class ResetPasswordResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password_result)

        init()
    }

    private fun init(){
        setListeners()
    }

    private fun setListeners(){
        backBtn.setOnClickListener { finish() }
        loginBtn.setOnClickListener {
            directLoginActivity()
        }
    }

    private fun directLoginActivity(){
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
    }
}