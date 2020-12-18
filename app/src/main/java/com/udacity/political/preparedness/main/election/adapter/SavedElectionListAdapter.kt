package com.udacity.political.preparedness.main.election.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.udacity.political.preparedness.databinding.ItemElectionsBinding
import com.udacity.political.preparedness.domain.model.ElectionDetailModel

class SavedElectionListAdapter(private val electionClick: (electionDetailModel: ElectionDetailModel) -> Unit) :
    ListAdapter<ElectionDetailModel, SavedElectionListAdapter.ItemViewHolder>(DiffCallback) {

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

        fun bind(electionDetailModel: ElectionDetailModel) {
            binding.titleTextView.text = electionDetailModel.name
            binding.descriptionTextView.text = electionDetailModel.electionDay.toString()
        }

        companion object {
            fun from(parent: ViewGroup): ItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemElectionsBinding.inflate(layoutInflater, parent, false)
                return ItemViewHolder(binding)
            }
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<ElectionDetailModel>() {
        override fun areItemsTheSame(
            oldItem: ElectionDetailModel,
            newItem: ElectionDetailModel
        ): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(
            oldItem: ElectionDetailModel,
            newItem: ElectionDetailModel
        ): Boolean {
            return oldItem.id == newItem.id
        }
    }

}