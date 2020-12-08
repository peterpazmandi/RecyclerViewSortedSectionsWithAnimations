package com.inspirecoding.recyclerviewsortedsectionswithanimations


import androidx.viewbinding.ViewBinding
import com.inspirecoding.recyclerviewsortedsectionswithanimations.databinding.LayoutFruitItemBinding

data class FruitItem(val name: String) : BaseItem {

    override val viewType: Int = BaseListAdapter.FRUIT_ITEM

    override val uniqueId: Any
        get() = name

    override fun bind(binding: ViewBinding, itemClickCallback: ((BaseItem) -> Unit)?) {

        val _binding = binding as LayoutFruitItemBinding

        _binding.root.setOnClickListener {
            itemClickCallback?.invoke(this)
        }
        _binding.textFruitName.text = name

    }
}