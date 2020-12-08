package com.inspirecoding.recyclerviewsortedsectionswithanimations

import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.viewbinding.ViewBinding

/**
 * A base adapter that most RecyclerViews should be able to use
 * The style of this adapter, with [BaseItem] used for the list, is based on the excellent
 * [Groupie](https://github.com/lisawray/groupie) library.
 *
 * @param itemClickCallback An optional callback for clicks on an item
 * */
class BaseListAdapter(
    private val itemClickCallback: ((BaseItem) -> Unit)?
) : ListAdapter<BaseItem, BaseViewHolder>(

    AsyncDifferConfig.Builder<BaseItem>(object : DiffUtil.ItemCallback<BaseItem>() {
        override fun areItemsTheSame(oldItem: BaseItem, newItem: BaseItem): Boolean {
            return oldItem.uniqueId == newItem.uniqueId
        }

        override fun areContentsTheSame(oldItem: BaseItem, newItem: BaseItem): Boolean {
            return oldItem == newItem
        }
    }).build()

) {

    private lateinit var binding : ViewBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {

        return BaseViewHolder(binding.root)
    }

    override fun getItemViewType(position: Int) : Int {
        binding = getItem(position).itemViewType

        return binding.root.id
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        getItem(position).bind(binding, itemClickCallback)
    }
}