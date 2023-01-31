package com.melyseev.testremoteconfig.presentation.dummy_fragment

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.melyseev.testremoteconfig.R

class SportsEventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tv_sports_event = itemView.findViewById<TextView>(R.id.tv_sport_event)
    val img = itemView.findViewById<ImageView>(R.id.imageView)
}