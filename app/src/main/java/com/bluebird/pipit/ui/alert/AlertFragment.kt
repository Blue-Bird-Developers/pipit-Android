package com.bluebird.pipit.ui.alert

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.bluebird.pipit.R
import com.bluebird.pipit.ui.alertsetting.AlertSettingActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class AlertFragment : Fragment() {

    private val tabLayoutTitleList = arrayOf("키워드 알림", "새 소식")

    private lateinit var viewPagerAdapter: AlertViewPagerAdapter
    private lateinit var viewPager: ViewPager2
    private lateinit var alertSettingBtn: ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_alert, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setViewPagerAndTab(view)
        setListeners(view)
    }

    private fun setViewPagerAndTab(view: View){
        viewPagerAdapter = AlertViewPagerAdapter(this)
        viewPager = view.findViewById(R.id.alertViewPager)
        viewPager.adapter = viewPagerAdapter

        val tabLayout: TabLayout = view.findViewById(R.id.alertTabLayout)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabLayoutTitleList[position]
        }.attach()
    }

    private fun setListeners(view: View){
        alertSettingBtn = view.findViewById(R.id.alertSettingBtn)
        alertSettingBtn.setOnClickListener {
            val intent = Intent(view.context, AlertSettingActivity::class.java)
            startActivity(intent)
        }
    }
}