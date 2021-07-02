package com.bluebird.pipit.ui.home.tab

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_edit_tab_recyclerview.view.*

class EditTabRecyclerViewHolder(val view: View): RecyclerView.ViewHolder(view) {

    fun bind(item: String){
        view.itemTitle.text = item
    }

}