package com.inspirecoding.recyclerviewsortedsectionswithanimations


import kotlinx.android.synthetic.main.layout_fruit_item.*

data class FruitItem(val name: String) : BaseItem {

    override val layoutId: Int
        get() = 2

    override val uniqueId: Any
        get() = name

    override fun bind(holder: BaseViewHolder, itemClickCallback: ((BaseItem) -> Unit)?) {

        holder.containerView.setOnClickListener {
            itemClickCallback?.invoke(this)
        }
        holder.text_fruit_name.text = name

    }
}
