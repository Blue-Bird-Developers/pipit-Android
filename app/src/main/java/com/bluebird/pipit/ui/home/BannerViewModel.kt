package com.bluebird.pipit.ui.home

import android.app.Application
import androidx.fragment.app.Fragment
import androidx.lifecycle.AndroidViewModel

class BannerViewModel(application: Application): AndroidViewModel(application) {

    // TODO: 2021/06/27 banner 데이터 가져오는 로직 구현
    private var dataList: MutableList<Fragment> = mutableListOf()

    fun getDataList(): MutableList<Fragment>{
        return dataList
    }

    fun setDataList(){
        dataList.add(BannerFragment())
        dataList.add(BannerFragment())
        dataList.add(BannerFragment())
        dataList.add(BannerFragment())
    }

}