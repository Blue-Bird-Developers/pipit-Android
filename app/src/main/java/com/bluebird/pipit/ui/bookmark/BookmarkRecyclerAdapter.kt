package com.bluebird.pipit.ui.bookmark

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bluebird.pipit.databinding.ItemBookmarkRecyclerviewBinding

class BookmarkRecyclerAdapter(
    viewModel: BookmarkViewModel
) : RecyclerView.Adapter<BookmarkRecyclerViewHolder>() {

    private val bookMarkRecyclerViewModel = viewModel

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarkRecyclerViewHolder {
        val binding: ItemBookmarkRecyclerviewBinding = ItemBookmarkRecyclerviewBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return BookmarkRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int = bookMarkRecyclerViewModel.getDataList().size

    override fun onBindViewHolder(holder: BookmarkRecyclerViewHolder, position: Int) {
        val item = bookMarkRecyclerViewModel.getDataItem(position)
        holder.bind(item, bookMarkRecyclerViewModel)
    }

}