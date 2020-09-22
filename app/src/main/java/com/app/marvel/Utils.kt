package com.app.marvel

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.app.marvel.data.model.Marvel

@BindingAdapter("marvelList")
fun RecyclerView.marvelList(items: List<Marvel>?) {
    items?.let {
        (adapter as MarvelAdapter).submitList(it)
    }
}