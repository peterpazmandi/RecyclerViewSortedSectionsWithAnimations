package com.inspirecoding.recyclerviewsortedsectionswithanimations


import androidx.viewbinding.ViewBinding
import com.inspirecoding.recyclerviewsortedsectionswithanimations.databinding.LayoutHeaderItemBinding

data class HeaderItem(val letter: String) : BaseItem {

    override val viewType: Int = BaseListAdapter.HEADER_ITEM

    override val uniqueId = letter

    override fun bind (binding : ViewBinding, itemClickCallback: ((BaseItem) -> Unit)?) {

        val _binding = binding as LayoutHeaderItemBinding

        _binding.textHeader.text = letter
    }

}
