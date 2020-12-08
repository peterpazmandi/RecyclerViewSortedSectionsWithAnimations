package com.inspirecoding.recyclerviewsortedsectionswithanimations


import android.content.Context
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import com.inspirecoding.recyclerviewsortedsectionswithanimations.databinding.LayoutHeaderItemBinding

data class HeaderItem(val letter: String, val context: Context) : BaseItem {

    override val itemViewType: ViewBinding
        get() {
            val layoutInflater = LayoutInflater.from(context)
            return LayoutHeaderItemBinding.inflate(layoutInflater)
        }

    override val uniqueId = letter

    override fun bind (binding : ViewBinding, itemClickCallback: ((BaseItem) -> Unit)?) {

        val _binding = binding as LayoutHeaderItemBinding

        _binding.textHeader.text = letter
    }

}
