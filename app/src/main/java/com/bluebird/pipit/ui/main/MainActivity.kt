package com.bluebird.pipit.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.bluebird.pipit.R
import com.bluebird.pipit.ui.main.bookmark.BookmarkFragment
import com.bluebird.pipit.ui.main.home.HomeFragment
import com.bluebird.pipit.ui.main.alert.AlertFragment
import com.bluebird.pipit.ui.main.welcome.WelcomeFragment
import com.bluebird.pipit.ui.main.welcome.WelcomeSettingFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), WelcomeFragment.OnButtonClickListener,
    WelcomeSettingFragment.OnButtonClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.mainFrame, HomeFragment()).commit()
        init()
    }

    private fun init(){
        setListeners()
        openWelcome()
    }

    private fun setListeners(){
        setBottomNavListener()
    }

    private fun setBottomNavListener(){
        bottomNavigationBar.setOnNavigationItemSelectedListener{ item ->
            when(item.itemId){
                R.id.nav_home -> {
                    replaceFragment(HomeFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.nav_bookmark -> {
                    replaceFragment(BookmarkFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.nav_mypage -> {
                    replaceFragment(AlertFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                else -> {
                    return@setOnNavigationItemSelectedListener false
                }
            }
        }
    }

    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.mainFrame, fragment).commit()
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