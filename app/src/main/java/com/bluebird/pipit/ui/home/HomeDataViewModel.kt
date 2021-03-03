package com.bluebird.pipit.ui.home

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.bluebird.pipit.dataclass.HomeDataListItem

class HomeDataViewModel(application: Application): AndroidViewModel(application) {
    private var dataList: MutableList<HomeDataListItem> = mutableListOf()

    var openActionLiveData: MutableLiveData<HomeDataListItem> = MutableLiveData()
    var checkBoxLiveData: MutableLiveData<View> = MutableLiveData()

    fun getDataList(): MutableList<HomeDataListItem> = dataList

    fun getDataItem(pos: Int): HomeDataListItem = dataList[pos]

    fun setData(){
        dataList.add(HomeDataListItem(0, "http://www.sookmyung.ac.kr/","장학", "학업우수장학금 선발기준 변경 안내", "학생지원센터", "스노위", "1분전", false))
        dataList.add(HomeDataListItem(1, "http://www.sookmyung.ac.kr/","장학", "[공지] 2021-1학기 영어교양필수 배치고사 결과 안내 (2월4일~2월8일 응시자대상)", "학생지원센터", "스노위", "1분전", true))
        dataList.add(HomeDataListItem(2, "http://www.sookmyung.ac.kr/","장학", "hi", "학생지원센터", "스노위", "1분전", false))
        dataList.add(HomeDataListItem(3, "http://www.sookmyung.ac.kr/","장학", "피핏", "학생지원센터", "스노위", "1분전", false))
        dataList.add(HomeDataListItem(4, "http://www.sookmyung.ac.kr/","장학", "안녕", "학생지원센터", "스노위", "1분전", false))
        dataList.add(HomeDataListItem(5, "http://www.sookmyung.ac.kr/","장학", "학업우수장학금 선발기준 변경 안내", "학생지원센터", "스노위", "1분전", false))
        dataList.add(HomeDataListItem(6, "http://www.sookmyung.ac.kr/","장학", "학업우수장학금 선발기준 변경 안내", "학생지원센터", "스노위", "1분전", false))
        dataList.add(HomeDataListItem(7, "http://www.sookmyung.ac.kr/","장학", "학업우수장학금 선발기준 변경 안내", "학생지원센터", "스노위", "1분전", false))
        dataList.add(HomeDataListItem(8, "http://www.sookmyung.ac.kr/","장학", "학업우수장학금 선발기준 변경 안내", "학생지원센터", "스노위", "1분전", false))
        dataList.add(HomeDataListItem(9, "http://www.sookmyung.ac.kr/","장학", "학업우수장학금 선발기준 변경 안내", "학생지원센터", "스노위", "1분전", false))
        dataList.add(HomeDataListItem(10, "http://www.sookmyung.ac.kr/","장학", "학업우수장학금 선발기준 변경 안내", "학생지원센터", "스노위", "1분전", false))
    }

    fun setItem(dataItem: HomeDataListItem){
        openActionLiveData.value = dataItem
    }

    fun checkBoxListener(view: View, item: HomeDataListItem){
        checkBoxLiveData.value = view
        changeItemBookmark(item)
    }

    private fun changeItemBookmark(item: HomeDataListItem){
        for (dataItem in dataList){
            if (dataItem.id == item.id){
                dataItem.bookmark = !dataItem.bookmark
            }
        }
    }
}