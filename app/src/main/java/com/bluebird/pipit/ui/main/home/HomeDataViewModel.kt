package com.bluebird.pipit.ui.main.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.bluebird.pipit.dataclass.HomeDataListItem

class HomeDataViewModel(application: Application): AndroidViewModel(application) {
    private var dataList: MutableList<HomeDataListItem> = mutableListOf()

    var url: MutableLiveData<String> = MutableLiveData()

    fun getDataList(): MutableList<HomeDataListItem>{
        return dataList
    }

    fun setData(){
        dataList.add(HomeDataListItem("http://www.sookmyung.ac.kr/","장학", "학업우수장학금 선발기준 변경 안내", "학생지원센터", "스노위", "1분전", false))
        dataList.add(HomeDataListItem("http://www.naver.com/","장학", "pipit", "학생지원센터", "스노위", "1분전", true))
        dataList.add(HomeDataListItem("http://www.sookmyung.ac.kr/","장학", "hi", "학생지원센터", "스노위", "1분전", false))
        dataList.add(HomeDataListItem("http://www.sookmyung.ac.kr/","장학", "피핏", "학생지원센터", "스노위", "1분전", false))
        dataList.add(HomeDataListItem("http://www.sookmyung.ac.kr/","장학", "안녕", "학생지원센터", "스노위", "1분전", false))
        dataList.add(HomeDataListItem("http://www.sookmyung.ac.kr/","장학", "학업우수장학금 선발기준 변경 안내", "학생지원센터", "스노위", "1분전", false))
        dataList.add(HomeDataListItem("http://www.sookmyung.ac.kr/","장학", "학업우수장학금 선발기준 변경 안내", "학생지원센터", "스노위", "1분전", false))
        dataList.add(HomeDataListItem("http://www.sookmyung.ac.kr/","장학", "학업우수장학금 선발기준 변경 안내", "학생지원센터", "스노위", "1분전", false))
        dataList.add(HomeDataListItem("http://www.sookmyung.ac.kr/","장학", "학업우수장학금 선발기준 변경 안내", "학생지원센터", "스노위", "1분전", false))
        dataList.add(HomeDataListItem("http://www.sookmyung.ac.kr/","장학", "학업우수장학금 선발기준 변경 안내", "학생지원센터", "스노위", "1분전", false))
        dataList.add(HomeDataListItem("http://www.sookmyung.ac.kr/","장학", "학업우수장학금 선발기준 변경 안내", "학생지원센터", "스노위", "1분전", false))
    }

    fun setUrl(pos: Int){
        url.value = dataList[pos].url
    }

    fun getCategory(pos: Int): String{
        return dataList[pos].category
    }

    fun getTitle(pos: Int): String{
        return dataList[pos].title
    }

    fun getTeam(pos: Int): String{
        return dataList[pos].team
    }

    fun getSource(pos: Int): String{
        return dataList[pos].source
    }

    fun getUploadTime(pos: Int): String{
        return dataList[pos].uploadTime
    }

    fun getBookmark(pos: Int): Boolean{
        return dataList[pos].bookmark
    }
}