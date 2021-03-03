package com.bluebird.pipit.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.bluebird.pipit.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment() {

    private val tabLayoutTitleList = arrayOf("전체", "학사", "장학", "졸업", "취업", "스펙", "교환", "행사", "공모전", "강연", "간식배부")

    private lateinit var viewPagerAdapter: HomeViewPagerAdapter
    private lateinit var viewPager: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setViewPagerAndTab(view)
    }

    private fun setViewPagerAndTab(view: View){
        viewPagerAdapter = HomeViewPagerAdapter(this)
        viewPager = view.findViewById(R.id.homeViewPager)
        viewPager.adapter = viewPagerAdapter

        val tabLayout: TabLayout = view.findViewById(R.id.homeTabLayout)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabLayoutTitleList[position]
        }.attach()
    }
}