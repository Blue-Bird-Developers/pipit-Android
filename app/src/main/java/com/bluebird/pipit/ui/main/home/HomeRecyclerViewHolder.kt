package com.bluebird.pipit.ui.main.home

import android.view.View
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bluebird.pipit.R

class HomeRecyclerViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    private val titleText = itemView.findViewById<TextView>(R.id.titleText)
    private val bookmarkBox = itemView.findViewById<CheckBox>(R.id.bookMarkCheckBox)

    fun bind(data: String, position: Int, checkBoxClick: (CompoundButton, Boolean) -> Unit, itemClick: (String) -> Unit){
        titleText.text = data
        itemView.setOnClickListener { itemClick("http://www.sookmyung.ac.kr/") }
        bookmarkBox.setOnCheckedChangeListener { compoundButton, isChecked ->
            checkBoxClick(compoundButton, isChecked) }
    }

}