package com.bluebird.pipit.ui.main.alert

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bluebird.pipit.R
import com.bluebird.pipit.ui.main.WebViewActivity

class AlertViewPagerFragment : Fragment() {

    var dataList: MutableList<String> = mutableListOf("hi", "pipit!", "hi", "pipit!", "hi", "pipit!", "hi", "pipit!")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_viewpager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }
}