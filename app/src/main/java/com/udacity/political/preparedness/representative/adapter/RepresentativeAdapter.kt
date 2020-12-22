package com.udacity.political.preparedness.representative.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.udacity.political.preparedness.R
import com.udacity.political.preparedness.databinding.ItemRepresentativeBinding
import com.udacity.political.preparedness.domain.model.representative.RepresentativeModel
import com.udacity.political.preparedness.util.visible

class RepresentativeAdapter(
    private val representativeClick: (representativeModel: RepresentativeModel) -> Unit,
    private val iconClick: (url: String) -> Unit
) :
    ListAdapter<RepresentativeModel, RepresentativeAdapter.ItemViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder.from(parent, parent.context, iconClick)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val model = getItem(position)
        holder.bind(model)
        holder.itemView.setOnClickListener {
            representativeClick(model)
        }
    }

    class ItemViewHolder(
        private val binding: ItemRepresentativeBinding,
        private val context: Context,
        private val iconClick: (url: String) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(representativeModel: RepresentativeModel) {
            representativeModel.image?.let {
                Glide.with(context)
                    .load(it)
                    .placeholder(R.drawable.ic_profile)
                    .error(R.drawable.ic_profile)
                    .into(binding.pictureImageView)
            }

            binding.titleTextView.text = representativeModel.title
            binding.nameTextView.text = representativeModel.name
            binding.descriptionTextView.text = representativeModel.party

            representativeModel.web?.let { url ->
                binding.webImageView.visible(true)
                binding.webImageView.setOnClickListener {
                    iconClick(url)
                }
            } ?: binding.webImageView.visible(false)

            representativeModel.facebook?.let { url ->
                binding.facebookImageView.visible(true)
                binding.webImageView.setOnClickListener {
                    iconClick(url)
                }
            } ?: binding.facebookImageView.visible(false)

            representativeModel.twitter?.let { url ->
                binding.twitterImageView.visible(true)
                binding.webImageView.setOnClickListener {
                    iconClick(url)
                }
            } ?: binding.twitterImageView.visible(false)

        }

        companion object {
            fun from(
                parent: ViewGroup,
                context: Context,
                iconClick: (url: String) -> Unit
            ): ItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemRepresentativeBinding.inflate(layoutInflater, parent, false)
                return ItemViewHolder(binding, context, iconClick)
            }
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<RepresentativeModel>() {
        override fun areItemsTheSame(
            oldItem: RepresentativeModel,
            newItem: RepresentativeModel
        ): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(
            oldItem: RepresentativeModel,
            newItem: RepresentativeModel
        ): Boolean {
            return oldItem.name == newItem.name
        }
    }

}