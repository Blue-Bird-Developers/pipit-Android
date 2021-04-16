package com.bluebird.pipit.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bluebird.pipit.R
import kotlinx.android.synthetic.main.activity_login.*

class PortalCertifyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_portal_certify)

        init()
    }

    private fun init(){
        setListeners()
    }

    private fun setListeners(){
        findIdBtn.setOnClickListener {
            // TODO: 4/16/21 아이디 찾기 로직 구현

            directFindIdResultActivity()
        }
    }

    private fun directFindIdResultActivity(){
        val intent = Intent(this, FindIdResultActivity::class.java)
        startActivity(intent)
    }
}