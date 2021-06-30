package com.bluebird.pipit.ui.setting

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bluebird.pipit.R

class SettingRecyclerAdapter(
    private val dataList: List<String>,
    private val itemListener: (Int) -> Unit
) : RecyclerView.Adapter<SettingRecyclerViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SettingRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_setting_recyclerview, parent, false)
        return SettingRecyclerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: SettingRecyclerViewHolder, position: Int) {
        holder.bind(dataList[position], itemListener)
    }

}