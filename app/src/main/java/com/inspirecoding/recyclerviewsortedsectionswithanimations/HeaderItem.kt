package com.inspirecoding.recyclerviewsortedsectionswithanimations

import android.view.View
import com.inspirecoding.recyclerviewsortedsectionswithanimations.databinding.LayoutHeaderItemBinding

data class HeaderItem(val letter: String) : BaseItem<LayoutHeaderItemBinding> {

    override val layoutId = R.layout.layout_header_item

    override val uniqueId = letter

    override fun initializeViewBinding(view: View) = LayoutHeaderItemBinding.bind(view)

    override fun bind(
            binding: LayoutHeaderItemBinding,
            itemClickCallback: ((BaseItem<LayoutHeaderItemBinding>) -> Unit)?
    ) {
        binding.textHeader.text = letter
    }
}
