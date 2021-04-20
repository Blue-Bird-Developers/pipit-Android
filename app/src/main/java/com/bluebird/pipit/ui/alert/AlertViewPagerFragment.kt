package com.bluebird.pipit.ui.alert

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.bluebird.pipit.R

class AlertViewPagerFragment : Fragment() {

    private lateinit var recyclerAdapter: AlertRecyclerAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewModel: AlertViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_alert_viewpager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this).get(AlertViewModel::class.java)
        viewModel.setData()
        // TODO: 4/20/21 카드 클릭 시 링크 이동 observe 구현

        recyclerAdapter = AlertRecyclerAdapter(view.context, viewModel)
        recyclerAdapter.notifyDataSetChanged()
        recyclerView = view.findViewById(R.id.alertViewPagerRecyclerView)
        recyclerView.adapter = recyclerAdapter
    }
}