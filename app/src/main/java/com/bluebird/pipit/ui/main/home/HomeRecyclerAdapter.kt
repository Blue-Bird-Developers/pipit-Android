package com.bluebird.pipit.ui.main.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bluebird.pipit.databinding.ItemHomeRecyclerviewBinding

class HomeRecyclerAdapter(
    viewModel: HomeDataViewModel,
    private val context: Context,
    private val checkBoxClick: (View) -> Unit)
    : RecyclerView.Adapter<HomeRecyclerViewHolder>() {

    private val homeViewModel = viewModel

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeRecyclerViewHolder {
        val binding: ItemHomeRecyclerviewBinding = ItemHomeRecyclerviewBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return HomeRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int = homeViewModel.getDataList().size

    override fun onBindViewHolder(holder: HomeRecyclerViewHolder, position: Int) {
        holder.bind(homeViewModel, position, checkBoxClick)
    }
}