package com.bluebird.pipit.ui.bookmark

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bluebird.pipit.R

class BookmarkFragment : Fragment() {

    private lateinit var recyclerAdapter: BookmarkRecyclerAdapter
    private lateinit var viewModel: BookmarkViewModel
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bookmark, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerAdapter = BookmarkRecyclerAdapter()
        recyclerAdapter.notifyDataSetChanged()
        recyclerView = view.findViewById(R.id.bookmarkRecyclerView)
        recyclerView.adapter = recyclerAdapter
    }
}