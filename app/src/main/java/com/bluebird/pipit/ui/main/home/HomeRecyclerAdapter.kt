package com.bluebird.pipit.ui.main.home

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bluebird.pipit.R
import com.bluebird.pipit.ui.main.WebViewActivity

class HomeRecyclerAdapter(
    private val context: Context,
    private val dataList: MutableList<String>,
    private val checkBoxClick: (CompoundButton, Boolean) -> Unit)
    : RecyclerView.Adapter<HomeRecyclerViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeRecyclerViewHolder {
        val view = LayoutInflater.from(context).inflate(
            R.layout.item_home_recyclerview,
            parent, false)
        return HomeRecyclerViewHolder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: HomeRecyclerViewHolder, position: Int) {
        holder.bind(dataList[position], position, checkBoxClick){
            val intent = Intent(context, WebViewActivity::class.java)
            intent.putExtra("url", it)
            startActivity(context, intent, null)
        }
    }
}