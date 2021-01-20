package com.bluebird.pipit.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bluebird.pipit.R

class MainActivity : AppCompatActivity(), WelcomeFragment.onButtonClickListener,
    WelcomeSettingFragment.onButtonClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init(){
        openWelcome()
    }

    private fun openWelcome(){
        val bottomSheet = WelcomeFragment()
        bottomSheet.isCancelable = false
        bottomSheet.show(supportFragmentManager, bottomSheet.tag)
    }

    private fun openWelcomeSetting(){
        val bottomSheet = WelcomeSettingFragment()
        bottomSheet.isCancelable = false
        bottomSheet.show(supportFragmentManager, bottomSheet.tag)
    }

    override fun onWelcomeFragmentButton() {
        openWelcomeSetting()
    }

    override fun onWelcomeSettingFragmentButton() {
        // TODO: 2021/01/21 설정하기 버튼 구현
    }
}