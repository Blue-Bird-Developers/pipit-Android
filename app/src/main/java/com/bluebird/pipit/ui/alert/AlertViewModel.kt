package com.bluebird.pipit.ui.alert

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.bluebird.pipit.dataclass.KeywordAlertListItem

class AlertViewModel(application: Application): AndroidViewModel(application) {
    private var dataList: MutableList<KeywordAlertListItem> = mutableListOf()

    fun getDataList(): MutableList<KeywordAlertListItem> = dataList

    fun getDataItem(pos: Int): KeywordAlertListItem = dataList[pos]

    fun setData(){
        dataList.add(KeywordAlertListItem(0, "http://www.sookmyung.ac.kr/","장학", "[수학과] 2020 선배와의 대화_여대생 특성2020 선배와의 대화_여대생 특성", "학생지원센터", "스노위", "1분전", 1))
        dataList.add(KeywordAlertListItem(1, "http://www.sookmyung.ac.kr/","장학", "[수학과] pipit", "학생지원센터", "스노위", "1분전", 0))
        dataList.add(KeywordAlertListItem(2, "http://www.sookmyung.ac.kr/","장학", "[수학과] hello!", "학생지원센터", "스노위", "2분전", 0))
        dataList.add(KeywordAlertListItem(3, "http://www.sookmyung.ac.kr/","장학", "[수학과] pipit", "학생지원센터", "스노위", "1분전", 0))
        dataList.add(KeywordAlertListItem(4, "http://www.sookmyung.ac.kr/","장학", "[수학과] hello!", "학생지원센터", "스노위", "2분전", 0))
        dataList.add(KeywordAlertListItem(5, "http://www.sookmyung.ac.kr/","장학", "[수학과] hello!", "학생지원센터", "스노위", "1분전", 0))
        dataList.add(KeywordAlertListItem(6, "http://www.sookmyung.ac.kr/","장학", "[수학과] hello!", "학생지원센터", "스노위", "1분전", 0))
        dataList.add(KeywordAlertListItem(7, "http://www.sookmyung.ac.kr/","장학", "[수학과] hello!", "학생지원센터", "스노위", "2분전", 0))
    }
}