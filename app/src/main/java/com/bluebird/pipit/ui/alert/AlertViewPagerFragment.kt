package com.bluebird.pipit.ui.alert

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bluebird.pipit.R

class AlertViewPagerFragment : Fragment() {

    var dataList: MutableList<String> = mutableListOf("[수학과] 2020 선배와의 대화_여대생 특성2020 선배와의 대화_여대생 특성", "pipit!", "hi", "pipit!", "hi", "pipit!", "hi", "pipit!")

    private lateinit var recyclerAdapter: AlertRecyclerAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_alert_viewpager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerAdapter = AlertRecyclerAdapter(view.context, dataList)
        recyclerAdapter.notifyDataSetChanged()
        recyclerView = view.findViewById(R.id.alertViewPagerRecyclerView)
        recyclerView.adapter = recyclerAdapter
    }
}