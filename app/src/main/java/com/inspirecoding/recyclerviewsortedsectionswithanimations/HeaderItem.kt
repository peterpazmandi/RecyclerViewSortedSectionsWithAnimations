package com.inspirecoding.recyclerviewsortedsectionswithanimations


import kotlinx.android.synthetic.main.layout_header_item.*

data class HeaderItem(val letter: String) : BaseItem {

    override val layoutId: Int
        get() = 1

    override val uniqueId = letter

    override fun bind (holder: BaseViewHolder, itemClickCallback: ((BaseItem) -> Unit)?) {
        holder.text_header.text = letter
    }

}
