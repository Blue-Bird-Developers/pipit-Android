package com.bluebird.pipit.ui.alertsetting

import android.annotation.SuppressLint
import android.graphics.Typeface
import androidx.recyclerview.widget.RecyclerView
import com.bluebird.pipit.R
import com.bluebird.pipit.databinding.ItemAlertSettingRecyclerviewBinding
import com.bluebird.pipit.dataclass.AlertSettingButtonItem
import com.google.android.material.card.MaterialCardView

class AlertSettingRecyclerViewHolder(binding: ItemAlertSettingRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {
    private val binding = binding

    @SuppressLint("ResourceAsColor")
    fun bind(viewModel: AlertSettingViewModel, item: AlertSettingButtonItem){
        binding.alertSettingViewModel = viewModel
        binding.item = item
        binding.executePendingBindings()

        binding.alertSettingCardView.setOnClickListener {
            (it as MaterialCardView).apply {
                isChecked = !isChecked
//                if (isChecked){
//                    binding.checkImg.apply {
//                        setImageResource(R.drawable.ic_check_circle_fill)
//                        setColorFilter(R.color.colorPrimary)
//                    }
//                }else{
//                    binding.checkImg.apply {
//                        setImageResource(R.drawable.ic_check_circle)
//                        setColorFilter(R.color.gray300)
//                    }
//                }
            }
        }
    }
}