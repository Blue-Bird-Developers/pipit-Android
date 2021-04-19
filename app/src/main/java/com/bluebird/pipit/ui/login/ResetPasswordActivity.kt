package com.bluebird.pipit.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bluebird.pipit.R
import kotlinx.android.synthetic.main.activity_reset_password.*

class ResetPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)

        init()
    }

    private fun init(){
        setListeners()
    }

    private fun setListeners(){
        backBtn.setOnClickListener { finish() }
        resetPasswordBtn.setOnClickListener {
            // TODO: 2021/04/19 비밀번호 재설정하는 로직 추가

            directResetPasswordResultActivity()
        }
    }


    private fun directResetPasswordResultActivity(){
        val intent = Intent(this, ResetPasswordResultActivity::class.java)
        startActivity(intent)
    }
}