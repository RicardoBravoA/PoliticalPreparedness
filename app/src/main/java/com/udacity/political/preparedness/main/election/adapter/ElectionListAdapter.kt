package com.udacity.political.preparedness.main.election.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.udacity.political.preparedness.databinding.ItemElectionsBinding
import com.udacity.political.preparedness.domain.model.ElectionModel

class ElectionListAdapter(private val electionClick: (electionModel: ElectionModel) -> Unit) :
    ListAdapter<ElectionModel, ElectionListAdapter.ItemViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val model = getItem(position)
        holder.bind(model)
        holder.itemView.setOnClickListener {
            electionClick(model)
        }
    }

    class ItemViewHolder(private var binding: ItemElectionsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(electionModel: ElectionModel) {
            binding.titleTextView.text = electionModel.name
            binding.descriptionTextView.text = electionModel.electionDay.toString()
        }

        companion object {
            fun from(parent: ViewGroup): ItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemElectionsBinding.inflate(layoutInflater, parent, false)
                return ItemViewHolder(binding)
            }
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<ElectionModel>() {
        override fun areItemsTheSame(oldItem: ElectionModel, newItem: ElectionModel): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: ElectionModel, newItem: ElectionModel): Boolean {
            return oldItem.id == newItem.id
        }
    }

}