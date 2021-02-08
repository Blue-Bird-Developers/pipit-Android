package com.bluebird.pipit.ui.main.home

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bluebird.pipit.databinding.ItemHomeRecyclerviewBinding

class HomeRecyclerViewHolder(binding: ItemHomeRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {
    private val binding = binding

    fun bind(viewModel: HomeDataViewModel, position: Int, checkBoxClick: (View) -> Unit){
        binding.homeDataViewModel = viewModel
        binding.pos = position
        binding.executePendingBindings()

        binding.bookMarkCheckBox.setOnClickListener { checkBoxClick(it) }
    }

}