package com.melyseev.testremoteconfig.presentation.dummy_fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.melyseev.testremoteconfig.R

class SportsEventAdapter() :
    ListAdapter<SportsEventUI, SportsEventViewHolder>(SportsEventItemDiffCallback()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportsEventViewHolder {
        var layout = R.layout.sport_event_short
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return SportsEventViewHolder(view)
    }

    override fun onBindViewHolder(holder: SportsEventViewHolder, position: Int) {
        val element = getItem(position)
        holder.tv_sports_event.text = "${element.textEvent} #${element.id}"

        Glide.with(holder.itemView.context)
            .load(R.drawable.img)
            .centerCrop()
            .into(holder.img)
        /*
        Glide.with(holder.itemView.context)
            .load(element.urlImage)
            .centerCrop()
            .into(holder.img)

         */
    }

}