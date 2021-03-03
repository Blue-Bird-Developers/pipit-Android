package com.bluebird.pipit.ui.alertsetting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bluebird.pipit.R
import com.bluebird.pipit.databinding.ActivityAlertSettingBinding
import kotlinx.android.synthetic.main.activity_alert_setting.*

class AlertSettingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAlertSettingBinding
    private lateinit var viewModel: AlertSettingViewModel
    private lateinit var recyclerAdapter: AlertSettingRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_alert_setting)
        init()
    }

    private fun init(){
        setViewModel()
        setRecyclerView()
        setListeners()
    }

    private fun setViewModel(){
        viewModel = ViewModelProvider(this).get(AlertSettingViewModel::class.java)
        viewModel.setData()
        binding.alertSettingViewModel = viewModel
        binding.lifecycleOwner = this
    }

    private fun setRecyclerView(){
        recyclerAdapter = AlertSettingRecyclerAdapter(viewModel)
        recyclerAdapter.notifyDataSetChanged()
        alertSettingRecyclerView.adapter = recyclerAdapter
    }

    private fun setListeners(){
        backBtn.setOnClickListener { finish() }
    }
}