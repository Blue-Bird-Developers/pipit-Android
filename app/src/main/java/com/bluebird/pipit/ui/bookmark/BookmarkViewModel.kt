package com.bluebird.pipit.ui.bookmark

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.bluebird.pipit.dataclass.HomeDataListItem

class BookmarkViewModel(application: Application) : AndroidViewModel(application) {

    private val dataList: MutableList<HomeDataListItem> = mutableListOf()
    var openActionLiveData: MutableLiveData<HomeDataListItem> = MutableLiveData()
    var checkBoxLiveData: MutableLiveData<View> = MutableLiveData()

    fun setData(){
        dataList.add(HomeDataListItem(0, "http://www.sookmyung.ac.kr/","장학", "학업우수장학금 선발기준 변경 안내", "학생지원센터", "스노위", "1분전", false))
        dataList.add(HomeDataListItem(1, "http://www.sookmyung.ac.kr/","장학", "피핏", "학생지원센터", "스노위", "1분전", false))
        dataList.add(HomeDataListItem(2, "http://www.sookmyung.ac.kr/","장학", "학업우수장학금 선발기준 변경 안내", "학생지원센터", "스노위", "1분전", false))
    }

    fun getDataList(): MutableList<HomeDataListItem> = dataList

    fun getDataItem(pos: Int): HomeDataListItem = dataList[pos]

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