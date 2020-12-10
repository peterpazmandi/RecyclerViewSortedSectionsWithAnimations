package com.inspirecoding.recyclerviewsortedsectionswithanimations

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

class BaseViewHolder<T : ViewBinding>(
    val binding: T,
) : RecyclerView.ViewHolder(binding.root)