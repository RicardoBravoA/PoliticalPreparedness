package com.udacity.political.preparedness.representative.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.udacity.political.preparedness.databinding.ItemRepresentativeBinding
import com.udacity.political.preparedness.domain.model.representative.OfficialModel

class RepresentativeAdapter(private val officialClick: (officialModel: OfficialModel) -> Unit) :
    ListAdapter<OfficialModel, RepresentativeAdapter.ItemViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val model = getItem(position)
        holder.bind(model)
        holder.itemView.setOnClickListener {
            officialClick(model)
        }
    }

    class ItemViewHolder(private var binding: ItemRepresentativeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(officialModel: OfficialModel) {
        }

        companion object {
            fun from(parent: ViewGroup): ItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemRepresentativeBinding.inflate(layoutInflater, parent, false)
                return ItemViewHolder(binding)
            }
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<OfficialModel>() {
        override fun areItemsTheSame(oldItem: OfficialModel, newItem: OfficialModel): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: OfficialModel, newItem: OfficialModel): Boolean {
            return oldItem.name == newItem.name
        }
    }

}