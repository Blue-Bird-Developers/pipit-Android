package com.bluebird.pipit.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bluebird.pipit.R
import com.bluebird.pipit.ui.MainActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        init()
    }

    private fun init(){
        setListeners()
    }

    private fun setListeners(){
        backBtn.setOnClickListener { finish() }
        loginBtn.setOnClickListener {
            // TODO: 2021/01/20 로그인 버튼 구현
            directMainActivity()
        }
        findIdBtn.setOnClickListener {
            // TODO: 2021/01/20 아이디 찾기 버튼 구현
        }
        resetPasswordBtn.setOnClickListener {
            // TODO: 2021/01/20 비밀번호 재설정 버튼 구현
        }
    }

    private fun directMainActivity(){
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }
}