package com.bluebird.pipit.ui.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class BannerViewPagerAdapter(fragment: Fragment, viewModel: BannerViewModel) : FragmentStateAdapter(fragment) {

    private val dataList: List<Fragment> = viewModel.getDataList()

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun createFragment(position: Int): Fragment {
        return dataList[position]
    }

}