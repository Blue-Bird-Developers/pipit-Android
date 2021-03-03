package com.bluebird.pipit.ui.alertsetting

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bluebird.pipit.databinding.ItemAlertSettingRecyclerviewBinding

class AlertSettingRecyclerAdapter(
    viewModel: AlertSettingViewModel)
    : RecyclerView.Adapter<AlertSettingRecyclerViewHolder>() {

    private var alertSettingViewModel = viewModel

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AlertSettingRecyclerViewHolder {
        val binding: ItemAlertSettingRecyclerviewBinding =
            ItemAlertSettingRecyclerviewBinding.inflate(
                LayoutInflater.from(parent.context), parent, false)
        return AlertSettingRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int = alertSettingViewModel.getDataList().size

    override fun onBindViewHolder(holder: AlertSettingRecyclerViewHolder, position: Int) {
        val item = alertSettingViewModel.getDataItem(position)
        holder.bind(alertSettingViewModel, item)
    }
}