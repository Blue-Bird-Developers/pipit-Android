package com.bluebird.pipit.ui.home

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bluebird.pipit.databinding.ItemHomeRecyclerviewBinding
import com.bluebird.pipit.dataclass.HomeDataListItem

class HomeRecyclerViewHolder(binding: ItemHomeRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {
    private val binding = binding

    fun bind(viewModel: HomeDataViewModel, item: HomeDataListItem, checkBoxClick: (View) -> Unit){
        binding.homeDataViewModel = viewModel
        binding.item = item
        binding.executePendingBindings()

        //binding.bookMarkCheckBox.setOnClickListener { checkBoxClick(it) }
    }

}