package com.bluebird.pipit.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.bluebird.pipit.R
import com.bluebird.pipit.databinding.FragmentHomeDataBinding
import com.bluebird.pipit.ui.WebViewActivity

class HomeDataFragment : Fragment() {
    private lateinit var binding: FragmentHomeDataBinding
    private lateinit var recyclerAdapter: HomeRecyclerAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewModel: HomeDataViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_data, container, false)
        viewModel = ViewModelProvider(this).get(HomeDataViewModel::class.java)
        viewModel.setData()
        viewModel.openActionLiveData.observe(viewLifecycleOwner, Observer {
            val intent = Intent(context, WebViewActivity::class.java)
            intent.putExtra("url", it.url)
            intent.putExtra("title", it.title)
            startActivity(intent)
        })
        viewModel.checkBoxLiveData.observe(viewLifecycleOwner, Observer(checkBoxClickListener))
        binding.homeDataViewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerAdapter = HomeRecyclerAdapter(viewModel, checkBoxClickListener)
        recyclerAdapter.notifyDataSetChanged()
        recyclerView = view.findViewById(R.id.homeViewPagerRecyclerView)
        recyclerView.adapter = recyclerAdapter
    }

    private val checkBoxClickListener = { view: View ->
        if (view is CheckBox) {
            if (view.isChecked) {
                var layout = layoutInflater.inflate(R.layout.toast_layout, null)
                layout.setBackgroundResource(R.drawable.toast_background)
                var textView: TextView = layout.findViewById(R.id.toastText)
                textView.text = "책갈피에 저장되었어요!"
                var t2 = Toast(context)
                t2.view = layout
                t2.show()
            }
        }
    }
}