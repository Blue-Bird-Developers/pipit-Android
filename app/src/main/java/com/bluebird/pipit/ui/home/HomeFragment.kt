package com.bluebird.pipit.ui.home

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.bluebird.pipit.R
import com.bluebird.pipit.ui.home.tab.EditTabActivity
import com.bluebird.pipit.ui.setting.SettingActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import io.github.vejei.viewpagerindicator.indicator.CircleIndicator
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

    private val tabDataList = arrayListOf("전체", "학사", "장학", "졸업", "취업", "스펙", "교환", "행사", "공모전", "강연", "간식배부")

    private lateinit var viewPagerAdapter: HomeViewPagerAdapter
    private lateinit var viewPager: ViewPager2
    private lateinit var bannerViewPagerAdapter: BannerViewPagerAdapter
    private lateinit var bannerViewPager: ViewPager2
    private lateinit var bannerViewModel: BannerViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setListeners()
        setViewPagerAndTab(view)
        setBannerViewPager(view)
    }

    private fun setViewPagerAndTab(view: View){
        viewPagerAdapter = HomeViewPagerAdapter(this)
        viewPager = view.findViewById(R.id.homeViewPager)
        viewPager.adapter = viewPagerAdapter

        val tabLayout: TabLayout = view.findViewById(R.id.homeTabLayout)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabDataList[position]
        }.attach()
    }

    private fun setBannerViewPager(view: View){
        bannerViewModel = ViewModelProvider(this).get(BannerViewModel::class.java)
        bannerViewModel.setDataList()
        bannerViewPagerAdapter = BannerViewPagerAdapter(this, bannerViewModel)
        bannerViewPager = view.findViewById(R.id.bannerViewPager)
        bannerViewPager.adapter = bannerViewPagerAdapter

        // indicator
        val circleIndicator: CircleIndicator = view.findViewById(R.id.bannerIndicator)
        circleIndicator.setWithViewPager2(bannerViewPager, false)
        circleIndicator.itemCount = bannerViewModel.getDataList().size
        circleIndicator.setAnimationMode(CircleIndicator.AnimationMode.NONE)
    }

    private fun setListeners(){
        settingBtn.setOnClickListener {
            val intent = Intent(context, SettingActivity::class.java)
            startActivity(intent)
        }
        searchBtn.setOnClickListener {  }
        editTabBtn.setOnClickListener {
            val intent = Intent(context, EditTabActivity::class.java)
            intent.putExtra("tabDataList", tabDataList)
            startActivity(intent)
        }
    }
}