package com.bluebird.pipit.ui.alert

import android.graphics.Color
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bluebird.pipit.R
import com.bluebird.pipit.dataclass.KeywordAlertListItem
import com.google.android.material.card.MaterialCardView

class AlertRecyclerViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    private val titleText = itemView.findViewById<TextView>(R.id.titleText)
    private val frame = itemView.findViewById<MaterialCardView>(R.id.cardViewFrame)

    fun bind(item: KeywordAlertListItem, viewModel: AlertViewModel, setCardBackgroundColor: (MaterialCardView, Int) -> Unit){
        titleText.text = item.title
        setCardBackgroundColor(frame, item.state)
    }
}