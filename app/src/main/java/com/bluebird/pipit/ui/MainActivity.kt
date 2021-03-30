package com.bluebird.pipit.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.bluebird.pipit.R
import com.bluebird.pipit.ui.welcome.WelcomeFragment
import com.bluebird.pipit.ui.welcome.WelcomeSettingFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), WelcomeFragment.OnButtonClickListener,
    WelcomeSettingFragment.OnButtonClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init(){
        setBottomNavigation()
        openWelcome()
    }

    private fun setBottomNavigation(){
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        bottomNavigationBar.setupWithNavController(navController)
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