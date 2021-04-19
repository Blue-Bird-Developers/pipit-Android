package com.bluebird.pipit.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bluebird.pipit.R
import kotlinx.android.synthetic.main.activity_signup_portal.*

class SignupPortalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_portal)
        
        init()
    }
    
    private fun init(){
        setListeners()
    }
    
    private fun setListeners(){
        backBtn.setOnClickListener { finish() }
        authenticationGuideBtn.setOnClickListener {
            // TODO: 2021/01/20 학번인증안내 버튼 구현 
        }
        policyBtn.setOnClickListener {
            // TODO: 2021/01/20 이용약관 및 개인정보 처리방침 버튼 구현
        }
        usePortalAuthenticationBtn.setOnClickListener {
            // TODO: 2021/01/20 포탈인증이용 버튼 구현 
        }
        agreeBtn.setOnClickListener {
            // TODO: 2021/01/20 동의하고 계속하기 버튼 구현
            val intent = Intent(this, JoinActivity::class.java)
            startActivity(intent)
        }
    }
}