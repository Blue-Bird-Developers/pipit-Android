package com.bluebird.pipit.ui.home.tab

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.bluebird.pipit.R
import kotlinx.android.synthetic.main.item_edit_tab_recyclerview.view.*

class TabItemTouchHelperCallback(
    val adapter: EditTabRecyclerAdapter
): ItemTouchHelper.Callback() {

    interface OnItemMoveListener {
        fun onItemMove(fromPosition: Int, toPosition: Int)
    }

    /**
     * 어느 방향으로 움직일지에 따라서 flag 받는것을 정의
     * 드래그는 위, 아래 액션이기 때문에 up, down 을 넘겨줌
     */
    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        val dragFlags = ItemTouchHelper.UP or ItemTouchHelper.DOWN
        return makeMovementFlags(dragFlags, 0)
    }

    // 움직일 때 실행할 메소드
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        adapter.onItemMove(viewHolder.adapterPosition, target.adapterPosition)
        return true
    }

    override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
        when(actionState){
            ItemTouchHelper.ACTION_STATE_DRAG -> {
                if (viewHolder != null) {
                    changeButtonImages(viewHolder, DRAG)
                }
            }
        }
    }

    override fun clearView(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder) {
        changeButtonImages(viewHolder, DROP)
        adapter.afterDragAndDrop()
    }

    // 좌우 스와이프
    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {}

    override fun isLongPressDragEnabled(): Boolean {
        return false
    }

    private fun changeButtonImages(viewHolder: RecyclerView.ViewHolder, state: Int){
        when(state){
            DRAG -> {
                viewHolder.itemView.dragBtn.setImageResource(R.drawable.ic_drag_vertical_blue)
                viewHolder.itemView.setBackgroundResource(R.drawable.blue_line_white_button)
                viewHolder.itemView.plusMinusBtn.setImageResource(R.drawable.ic_minus_circle_fill_blue)
            }
            DROP -> {
                viewHolder.itemView.dragBtn?.setImageResource(R.drawable.ic_drag_vertical)
                viewHolder.itemView.setBackgroundResource(R.drawable.gray_100_button)
                viewHolder.itemView.plusMinusBtn.setImageResource(R.drawable.ic_minus_circle_fill)
            }
        }
    }

    companion object{
        const val DRAG = 100
        const val DROP = 101
    }
}