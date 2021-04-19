package com.bluebird.pipit.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bluebird.pipit.R
import kotlinx.android.synthetic.main.activity_find_id_result.*

class FindIdResultActivity : AppCompatActivity() {

    private var isFindIdSuccess = true
    private var userId = "hello^^"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_id_result)

        init()
    }

    private fun init(){
        // TODO: 2021/04/19 아이디가 유효한지 체크하는 로직 추가

        setListeners()
        setResultOnBox(isFindIdSuccess, userId)
    }

    private fun setListeners(){
        signupBtn.setOnClickListener {
            val intent = if (isFindIdSuccess) {
                Intent(this, LoginActivity::class.java)
            }else{
                Intent(this, SignupPortalActivity::class.java)
            }
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }
        backBtn.setOnClickListener { finish() }
    }

    private fun setResultOnBox(success: Boolean, id: String){
        if(success){
            questionImg.visibility = View.INVISIBLE
            userIdText.text = id
            userIdText.visibility = View.VISIBLE
            resultExplanationText.text = getString(R.string.find_id_success_explanation)
            signupBtn.text = getString(R.string.login)
            signupBtn.setBackgroundResource(R.drawable.blue_button)
        }else{
            questionImg.visibility = View.VISIBLE
            userIdText.visibility = View.INVISIBLE
            resultExplanationText.text = getString(R.string.find_id_fail_explanation)
            signupBtn.text = getString(R.string.signup)
            signupBtn.setBackgroundResource(R.drawable.black_button)
        }
    }
}