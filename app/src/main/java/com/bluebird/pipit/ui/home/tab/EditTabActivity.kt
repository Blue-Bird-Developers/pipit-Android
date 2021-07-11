package com.bluebird.pipit.ui.home.tab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.bluebird.pipit.R
import com.bluebird.pipit.dataclass.HomeTabItem
import kotlinx.android.synthetic.main.activity_edit_tab.*

class EditTabActivity : AppCompatActivity(), EditTabRecyclerAdapter.OnListener {

    private var homeList: MutableList<String> = mutableListOf()
    private var dataList: MutableList<HomeTabItem> = mutableListOf()

    private lateinit var recyclerAdapter: EditTabRecyclerAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var touchHelper: ItemTouchHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_tab)

        setData()
        setRecyclerView()
        setListeners()
    }

    private fun setRecyclerView(){
        recyclerView = findViewById(R.id.editTabRecyclerView)
        recyclerAdapter = EditTabRecyclerAdapter(dataList, this)
        // 드래그 구현
        touchHelper = ItemTouchHelper(TabItemTouchHelperCallback(recyclerAdapter))
        touchHelper.attachToRecyclerView(recyclerView)
        recyclerAdapter.notifyDataSetChanged()
        recyclerView.adapter = recyclerAdapter
    }

    private fun setListeners(){
        backBtn.setOnClickListener { finish() }
    }

    override fun onStartDrag(viewHolder: EditTabRecyclerViewHolder) {
        touchHelper.startDrag(viewHolder)
    }

    override fun onPlusMinusClicked(position: Int) {
        // 데이터 추가, 삭제
    }

    private fun setData(){
        homeList = intent.getStringArrayListExtra("tabDataList")!!
        for (data in homeList){
            dataList.add(HomeTabItem(data, true))
        }
    }
}