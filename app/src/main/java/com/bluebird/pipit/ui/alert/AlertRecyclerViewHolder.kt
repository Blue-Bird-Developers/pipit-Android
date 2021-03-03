package com.bluebird.pipit.ui.alert

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bluebird.pipit.R

class AlertRecyclerViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    private val titleText = itemView.findViewById<TextView>(R.id.titleText)

    fun bind(data: String){
        titleText.text = data
    }
}