package com.inspirecoding.recyclerviewsortedsectionswithanimations

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.viewbinding.ViewBinding
import com.inspirecoding.recyclerviewsortedsectionswithanimations.databinding.LayoutFruitItemBinding
import com.inspirecoding.recyclerviewsortedsectionswithanimations.databinding.LayoutHeaderItemBinding

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

    companion object {
        val HEADER_ITEM = 0
        val FRUIT_ITEM = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        when(viewType)
        {
            HEADER_ITEM -> {
                binding = LayoutHeaderItemBinding.inflate(
                    layoutInflater, parent, false
                )
            }
            FRUIT_ITEM -> {
                binding = LayoutFruitItemBinding.inflate(
                    layoutInflater, parent, false
                )
            }
        }

        return BaseViewHolder(binding.root)
    }

    override fun getItemViewType(position: Int) = getItem(position).viewType

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        getItem(position).bind(binding, itemClickCallback)
    }
}