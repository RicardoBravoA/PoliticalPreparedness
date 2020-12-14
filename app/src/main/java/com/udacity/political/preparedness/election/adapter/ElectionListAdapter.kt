package com.udacity.political.preparedness.election.adapter

import android.widget.ListAdapter
import com.udacity.political.preparedness.network.models.Election

class ElectionListAdapter(private val clickListener: ElectionListener): ListAdapter<Election, ElectionViewHolder>(ElectionDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElectionViewHolder {
        return ElectionViewHolder.from(parent)
    }

    //TODO: Bind ViewHolder

    //TODO: Add companion object to inflate ViewHolder (from)
}

//TODO: Create ElectionViewHolder

//TODO: Create ElectionDiffCallback

//TODO: Create ElectionListener