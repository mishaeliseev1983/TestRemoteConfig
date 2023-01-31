package com.melyseev.testremoteconfig.presentation.dummy_fragment

import androidx.recyclerview.widget.DiffUtil

class SportsEventItemDiffCallback : DiffUtil.ItemCallback<SportsEventUI>() {
    override fun areItemsTheSame(oldItem: SportsEventUI, newItem: SportsEventUI) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: SportsEventUI, newItem: SportsEventUI) =
        oldItem == newItem
}