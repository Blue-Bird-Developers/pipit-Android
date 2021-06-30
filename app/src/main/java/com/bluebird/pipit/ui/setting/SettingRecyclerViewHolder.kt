package com.bluebird.pipit.ui.setting

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bluebird.pipit.R

class SettingRecyclerViewHolder(val view: View) : RecyclerView.ViewHolder(view){

    fun bind(item: String, itemListener: (Int) -> Unit){
        view.findViewById<TextView>(R.id.itemTitle).text = item
        view.setOnClickListener { itemListener(adapterPosition) }
    }
}