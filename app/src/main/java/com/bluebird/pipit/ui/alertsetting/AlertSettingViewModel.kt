package com.bluebird.pipit.ui.alertsetting

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.bluebird.pipit.dataclass.AlertSettingButtonItem

class AlertSettingViewModel(application: Application) : AndroidViewModel(application) {
    private var dataList: MutableList<AlertSettingButtonItem> = mutableListOf()
    var checked: MutableLiveData<Boolean> = MutableLiveData()

    fun getDataList(): MutableList<AlertSettingButtonItem> = dataList

    fun getDataItem(pos: Int): AlertSettingButtonItem = dataList[pos]

    fun setData(){
        dataList.add(AlertSettingButtonItem(true, "학사"))
        dataList.add(AlertSettingButtonItem(true, "장학"))
        dataList.add(AlertSettingButtonItem(true, "졸업"))
        dataList.add(AlertSettingButtonItem(true, "취업"))
        dataList.add(AlertSettingButtonItem(true, "교환"))
        dataList.add(AlertSettingButtonItem(true, "스펙"))
        dataList.add(AlertSettingButtonItem(true, "행사"))
        dataList.add(AlertSettingButtonItem(true, "공모전"))
        dataList.add(AlertSettingButtonItem(true, "강연"))
        dataList.add(AlertSettingButtonItem(true, "간식배부"))
    }

    fun changeChecked(pos: Int){
        dataList[pos].checked = !dataList[pos].checked
        checked.value = dataList[pos].checked
    }
}