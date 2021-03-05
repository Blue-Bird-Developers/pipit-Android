package com.bluebird.pipit.ui.alertsetting

import androidx.recyclerview.widget.RecyclerView
import com.bluebird.pipit.R
import com.bluebird.pipit.databinding.ItemAlertSettingRecyclerviewBinding
import com.bluebird.pipit.dataclass.AlertSettingButtonItem
import com.google.android.material.card.MaterialCardView

class AlertSettingRecyclerViewHolder(binding: ItemAlertSettingRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {
    private val binding = binding

    fun bind(viewModel: AlertSettingViewModel, item: AlertSettingButtonItem){
        binding.alertSettingViewModel = viewModel
        binding.item = item
        binding.executePendingBindings()

        binding.alertSettingCardView.isChecked = item.checked
        changeButtonStyle(item.checked)

        binding.alertSettingCardView.setOnClickListener {
            (it as MaterialCardView).apply {
                isChecked = !isChecked
            }
        }
        binding.alertSettingCardView.setOnCheckedChangeListener { card, isChecked ->
            changeButtonStyle(isChecked)
        }
    }

    private fun changeButtonStyle(isChecked: Boolean){
        if (isChecked){
            binding.apply {
                checkImg.setImageResource(R.drawable.ic_check_circle_fill_16)
                titleText.setTextAppearance(R.style.checkedAlertSettingButtonTextStyle)
            }
        }else{
            binding.apply {
                checkImg.setImageResource(R.drawable.ic_check_circle_16)
                titleText.setTextAppearance(R.style.uncheckedAlertSettingButtonTextStyle)
            }
        }
    }
}