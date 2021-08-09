package com.bluebird.pipit.ui.setting.changepw

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bluebird.pipit.R
import com.bluebird.pipit.ui.login.AccountCertifyActivity
import kotlinx.android.synthetic.main.activity_check_password.*

class CheckPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_password)

        init()
    }

    private fun init(){
        setListeners()
    }

    private fun setListeners(){
        backBtn.setOnClickListener { finish() }
        checkPasswordBtn.setOnClickListener {
            val intent = Intent(this, ChangePasswordActivity::class.java)
            startActivity(intent)
        }
        resetPasswordBtn.setOnClickListener { directAccountCertifyActivity() }
    }

    private fun directAccountCertifyActivity(){
        val intent = Intent(this, AccountCertifyActivity::class.java)
        startActivity(intent)
    }
}