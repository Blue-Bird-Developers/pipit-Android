package com.bluebird.pipit.ui.bookmark

import androidx.recyclerview.widget.RecyclerView
import com.bluebird.pipit.databinding.ItemBookmarkRecyclerviewBinding
import com.bluebird.pipit.dataclass.HomeDataListItem

class BookmarkRecyclerViewHolder(binding: ItemBookmarkRecyclerviewBinding)
    : RecyclerView.ViewHolder(binding.root) {

    private val binding = binding

    fun bind(item: HomeDataListItem, viewModel: BookmarkViewModel){
        binding.bookmarkViewModel = viewModel
        binding.item = item
        binding.executePendingBindings()
    }

}