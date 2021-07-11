package com.bluebird.pipit.ui.home.tab

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bluebird.pipit.R
import com.bluebird.pipit.dataclass.HomeTabItem
import kotlinx.android.synthetic.main.item_edit_tab_recyclerview.view.*
import java.util.*

class EditTabRecyclerAdapter(
    private var dataList: MutableList<HomeTabItem>,
    private val listener: OnListener
): RecyclerView.Adapter<EditTabRecyclerViewHolder>(),
    TabItemTouchHelperCallback.OnItemMoveListener{

    interface OnListener {
        fun onStartDrag(viewHolder: EditTabRecyclerViewHolder)
        fun onPlusMinusClicked(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EditTabRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_edit_tab_recyclerview, parent, false)
        return EditTabRecyclerViewHolder(view)
    }

    override fun getItemCount(): Int = dataList.size

    @SuppressLint("ClickableViewAccessibility")
    override fun onBindViewHolder(holder: EditTabRecyclerViewHolder, position: Int) {
        holder.bind(dataList[holder.adapterPosition])
        holder.view.dragBtn.setOnTouchListener { _, motionEvent ->
            if (!dataList[holder.adapterPosition].state)
                return@setOnTouchListener false
            if (motionEvent.action == MotionEvent.ACTION_DOWN)
                    listener.onStartDrag(holder)
            return@setOnTouchListener true
        }
        holder.view.plusMinusBtn.setOnClickListener {
            //listener.onPlusMinusClicked(position)
            changeDataListItem(holder.adapterPosition)
        }
    }

    override fun onItemMove(fromPosition: Int, toPosition: Int) {
        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                Collections.swap(dataList, i, i + 1)
            }
        } else {
            for (i in fromPosition downTo toPosition + 1) {
                Collections.swap(dataList, i, i - 1)
            }
        }
        notifyItemMoved(fromPosition, toPosition)
    }

    private fun changeDataListItem(pos: Int){
        if (pos != RecyclerView.NO_POSITION) {
            val title = dataList[pos].title
            val state = dataList[pos].state
            if (!state){
                for (i in dataList.indices){
                    if (!dataList[i].state){
                        dataList.add(i, HomeTabItem(title, true))
                        notifyItemInserted(i)
                        dataList.removeAt(pos+1)
                        notifyItemRemoved(pos+1)
                        break
                    }
                }
            }else{
                dataList.add(HomeTabItem(title, false))
                notifyItemInserted(dataList.size-1)
                dataList.removeAt(pos)
                notifyItemRemoved(pos)
            }
        }
    }

    fun afterDragAndDrop() {
        notifyDataSetChanged()
    }
}