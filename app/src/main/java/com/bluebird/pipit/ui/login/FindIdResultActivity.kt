package com.bluebird.pipit.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bluebird.pipit.R
import kotlinx.android.synthetic.main.activity_login_main.*

class FindIdResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_id_result)

        init()
    }

    private fun init(){
        setListeners()
    }

    private fun setListeners(){
        signupBtn.setOnClickListener {
            val intent = Intent(this, SignupPortalActivity::class.java)
            startActivity(intent)
        }
    }
}