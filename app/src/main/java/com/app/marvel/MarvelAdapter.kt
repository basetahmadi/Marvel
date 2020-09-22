package com.app.marvel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.app.marvel.data.model.Marvel
import com.app.marvel.databinding.ItemMarvelBinding


class MarvelAdapter :
    ListAdapter<Marvel, MarvelAdapter.ViewHolder>(MarvelDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder private constructor(private val binding: ItemMarvelBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Marvel) {
            binding.item = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val inflator = LayoutInflater.from(parent.context)
                val binding = ItemMarvelBinding.inflate(inflator, parent, false)
                binding.lifecycleOwner = parent.context as LifecycleOwner
                return ViewHolder(binding)
            }
        }

    }

    // چک میکنه ببینه تابع ها تغییر کردن یا نه ، ایا نیازی به رفرش دارند ؟
    private class MarvelDiffCallback : DiffUtil.ItemCallback<Marvel>() {
        override fun areItemsTheSame(oldItem: Marvel, newItem: Marvel): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Marvel, newItem: Marvel): Boolean {
            return oldItem == newItem
        }

    }
}