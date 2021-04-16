package com.bluebird.pipit.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bluebird.pipit.R
import kotlinx.android.synthetic.main.activity_find_id_result.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.backBtn
import kotlinx.android.synthetic.main.activity_login_main.*
import kotlinx.android.synthetic.main.activity_login_main.signupBtn

class FindIdResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_id_result)

        init()
    }

    private fun init(){
        setListeners()
        // 임시 test
        setResultOnBox(true)
    }

    private fun setListeners(){
        signupBtn.setOnClickListener {
            val intent = Intent(this, SignupPortalActivity::class.java)
            startActivity(intent)
        }
        backBtn.setOnClickListener { finish() }
    }

    private fun setResultOnBox(success: Boolean){
        if(success){
            questionImg.visibility = View.INVISIBLE
            userIdText.visibility = View.VISIBLE
            resultExplanationText.text = getString(R.string.find_id_success_explanation)
            // TODO: 4/16/21 버튼 스타일 바뀌는 로직 추가해야함
        }else{
            questionImg.visibility = View.VISIBLE
            userIdText.visibility = View.INVISIBLE
            resultExplanationText.text = getString(R.string.find_id_fail_explanation)
            // TODO: 4/16/21 버튼 스타일 바뀌는 로직 추가해야함
        }
    }
}