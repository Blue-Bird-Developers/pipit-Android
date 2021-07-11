package com.bluebird.pipit.ui.home.tab

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bluebird.pipit.R
import com.bluebird.pipit.dataclass.HomeTabItem
import kotlinx.android.synthetic.main.item_edit_tab_recyclerview.view.*

class EditTabRecyclerViewHolder(val view: View): RecyclerView.ViewHolder(view) {

    fun bind(item: HomeTabItem){
        if (!item.state){
            view.plusMinusBtn.setImageResource(R.drawable.ic_plus_circle)
            view.setBackgroundResource(R.drawable.gray_line_white_button)
        }else{
            view.plusMinusBtn.setImageResource(R.drawable.ic_minus_circle_fill)
            view.setBackgroundResource(R.drawable.gray_100_button)
        }
        view.itemTitle.text = item.title
    }

}