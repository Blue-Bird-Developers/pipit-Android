package com.bluebird.pipit.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bluebird.pipit.R
import kotlinx.android.synthetic.main.activity_login_main.*

class LoginMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_main)

        init()
    }

    private fun init(){
        setListeners()
    }

    private fun setListeners(){
        introduceBtn.setOnClickListener{
            // TODO: 2021/01/13  피핏을 소개합니다 클릭 시 이동
        }
        loginBtn.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        signupBtn.setOnClickListener {
            val intent = Intent(this, SignupPortalActivity::class.java)
            startActivity(intent)
        }
    }
}