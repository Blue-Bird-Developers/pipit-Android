package com.bluebird.pipit.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bluebird.pipit.R
import kotlinx.android.synthetic.main.activity_account_certify.*
import kotlinx.android.synthetic.main.activity_alert_setting.*
import kotlinx.android.synthetic.main.activity_alert_setting.backBtn

class AccountCertifyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_certify)

        init()
    }

    private fun init(){
        setListeners()
    }

    private fun setListeners(){
        backBtn.setOnClickListener { finish() }
        accountCertifyBtn.setOnClickListener {
            directResetPasswordActivity()
        }
    }

    private fun directResetPasswordActivity(){
        val intent = Intent(this, ResetPasswordActivity::class.java)
        startActivity(intent)
    }
}