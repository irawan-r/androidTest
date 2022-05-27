package com.amora.testandroid.ui


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.amora.testandroid.databinding.HomeItemBinding
import com.amora.testandroid.model.ResponseItem

class HomeAdapter(private val clickListener: AndroidListener) :
    ListAdapter<ResponseItem, HomeAdapter.HomeViewHolder>(DiffCallback) {
    class HomeViewHolder(private var binding: HomeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(clickListener: AndroidListener, data: ResponseItem) {
            binding.androidItem = data
            binding.executePendingBindings()
            binding.root.setOnClickListener {
                data.id?.apply {
                    clickListener.onClick(this)
                }
            }
        }
    }

    class AndroidListener(val clickListener: (animeId: Int) -> Unit) {
        fun onClick(animeId: Int) = clickListener(animeId)
    }

    object DiffCallback : DiffUtil.ItemCallback<ResponseItem>() {
        override fun areItemsTheSame(
            oldItem: ResponseItem,
            newItem: ResponseItem,
        ): Boolean {
            return oldItem.userId == newItem.userId
        }

        override fun areContentsTheSame(
            oldItem: ResponseItem,
            newItem: ResponseItem,
        ): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HomeViewHolder(
            HomeItemBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val android = getItem(position)
        holder.bind(clickListener, android)
    }
}