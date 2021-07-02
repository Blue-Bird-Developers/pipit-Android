package com.bluebird.pipit.ui.home.tab

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bluebird.pipit.R
import kotlinx.android.synthetic.main.item_edit_tab_recyclerview.view.*
import java.util.*

class EditTabRecyclerAdapter(
    private val dataList: MutableList<String>,
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
        holder.bind(dataList[position])
        holder.view.dragBtn.setOnTouchListener { _, motionEvent ->
            if(motionEvent.action == MotionEvent.ACTION_DOWN){
                listener.onStartDrag(holder)
            }
            return@setOnTouchListener true
        }
        holder.view.plusMinusBtn.setOnClickListener { listener.onPlusMinusClicked(position) }
    }

    override fun onItemMove(fromPosition: Int, toPosition: Int) {
        Collections.swap(dataList, fromPosition, toPosition)
        notifyItemMoved(fromPosition, toPosition)
    }

    fun afterDragAndDrop() {
        notifyDataSetChanged()
    }
}