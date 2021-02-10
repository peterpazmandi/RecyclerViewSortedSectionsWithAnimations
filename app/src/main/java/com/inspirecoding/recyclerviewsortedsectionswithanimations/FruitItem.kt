package com.inspirecoding.recyclerviewsortedsectionswithanimations


import android.view.View
import com.inspirecoding.recyclerviewsortedsectionswithanimations.databinding.LayoutFruitItemBinding

data class FruitItem(val name: String) : BaseItem<LayoutFruitItemBinding> {

    override val layoutId = R.layout.layout_fruit_item
    override val uniqueId = name

    override fun initializeViewBinding(view: View) = LayoutFruitItemBinding.bind(view)

    override fun bind(
        binding: LayoutFruitItemBinding,
        itemClickCallback: ((BaseItem<LayoutFruitItemBinding>) -> Unit)?
    ) {
        binding.root.setOnClickListener {
            itemClickCallback?.invoke(this)
        }
        binding.textFruitName.text = name
    }
}