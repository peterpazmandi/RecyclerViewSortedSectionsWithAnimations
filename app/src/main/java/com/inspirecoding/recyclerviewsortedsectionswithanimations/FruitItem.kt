package com.inspirecoding.recyclerviewsortedsectionswithanimations


import android.content.Context
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import com.inspirecoding.recyclerviewsortedsectionswithanimations.databinding.LayoutFruitItemBinding

data class FruitItem(val name: String, val context: Context) : BaseItem {

    override val itemViewType: ViewBinding
        get() {
            val layoutInflater = LayoutInflater.from(context)
            return LayoutFruitItemBinding.inflate(layoutInflater)
        }

    override val uniqueId = name

    override fun bind(binding: ViewBinding, itemClickCallback: ((BaseItem) -> Unit)?) {

        val _binding = binding as LayoutFruitItemBinding

        _binding.root.setOnClickListener {
            itemClickCallback?.invoke(this)
        }
        _binding.textFruitName.text = name

    }
}
