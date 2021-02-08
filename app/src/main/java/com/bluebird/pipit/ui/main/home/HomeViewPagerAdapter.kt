package com.bluebird.pipit.ui.main.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class HomeViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 11

    override fun createFragment(position: Int): Fragment {
        val fragment = HomeDataFragment()
        return fragment
    }
}