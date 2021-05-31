package com.bluebird.pipit.ui.bookmark

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.bluebird.pipit.dataclass.HomeDataListItem

class BookmarkViewModel(application: Application) : AndroidViewModel(application) {

    private val dataList: MutableList<HomeDataListItem> = mutableListOf()

    fun setData(){
        dataList.add(HomeDataListItem(0, "http://www.sookmyung.ac.kr/","장학", "학업우수장학금 선발기준 변경 안내", "학생지원센터", "스노위", "1분전", false))
        dataList.add(HomeDataListItem(3, "http://www.sookmyung.ac.kr/","장학", "피핏", "학생지원센터", "스노위", "1분전", false))
        dataList.add(HomeDataListItem(6, "http://www.sookmyung.ac.kr/","장학", "학업우수장학금 선발기준 변경 안내", "학생지원센터", "스노위", "1분전", false))
    }

    fun getDataList(): MutableList<HomeDataListItem> = dataList

    fun getDataItem(pos: Int): HomeDataListItem = dataList[pos]

}