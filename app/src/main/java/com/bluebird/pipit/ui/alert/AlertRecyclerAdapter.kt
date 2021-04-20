package com.bluebird.pipit.ui.alert

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bluebird.pipit.R
import com.google.android.material.card.MaterialCardView

class AlertRecyclerAdapter(
    private val context: Context,
    private val viewModel: AlertViewModel)
    : RecyclerView.Adapter<AlertRecyclerViewHolder>(){

    private val alertViewModel = viewModel

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlertRecyclerViewHolder {
        val view = LayoutInflater.from(context).inflate(
            R.layout.item_alert_recyclerview,
            parent,false)
        return AlertRecyclerViewHolder(view)
    }

    override fun getItemCount(): Int = alertViewModel.getDataList().size

    override fun onBindViewHolder(holder: AlertRecyclerViewHolder, position: Int) {
        val item = alertViewModel.getDataItem(position)
        holder.bind(item, alertViewModel, initCardBackgroundColor)
    }

    private val initCardBackgroundColor = { frame: MaterialCardView, state: Int ->
        // state 1 -> 안 읽은 알림
        if (state == 1){
            frame.setCardBackgroundColor(ContextCompat.getColor(context, R.color.transparentPrimary))
        }else{
            frame.setCardBackgroundColor(ContextCompat.getColor(context, R.color.white))
        }
    }
}