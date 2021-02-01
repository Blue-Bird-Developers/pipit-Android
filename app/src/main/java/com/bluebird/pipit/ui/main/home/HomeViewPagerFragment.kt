package com.bluebird.pipit.ui.main.home

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

class HomeViewPagerFragment : Fragment() {

    var dataList: MutableList<String> = mutableListOf("hi", "pipit!", "hi", "pipit!", "hi", "pipit!", "hi", "pipit!")

    private lateinit var fragmentAdapter: HomeRecyclerAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_viewpager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        fragmentAdapter = HomeRecyclerAdapter(view.context, dataList){ compoundButton, isChecked ->
            if (isChecked){
                var layout = layoutInflater.inflate(R.layout.toast_layout, null)
                layout.setBackgroundResource(R.drawable.black_button)
                var textView: TextView = layout.findViewById(R.id.toastText)
                textView.text = "책갈피에 저장되었어요!"
                var t2 = Toast(view.context)
                t2.view = layout
                t2.show()
            }else{
                // TODO: 2021/02/02 bookmark 안 되어 있을 때
            }
        }
        fragmentAdapter.notifyDataSetChanged()
        recyclerView = view.findViewById(R.id.homeViewPagerRecyclerView)
        recyclerView.adapter = fragmentAdapter
    }
}