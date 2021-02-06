package com.bluebird.pipit.ui.main.alert

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bluebird.pipit.R

class AlertRecyclerAdapter(
    private val context: Context,
    private val dataList: MutableList<String>)
    : RecyclerView.Adapter<AlertRecyclerViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlertRecyclerViewHolder {
        val view = LayoutInflater.from(context).inflate(
            R.layout.item_alert_recyclerview,
            parent,false)
        return AlertRecyclerViewHolder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: AlertRecyclerViewHolder, position: Int) {
        holder.bind(dataList[position])
    }
}