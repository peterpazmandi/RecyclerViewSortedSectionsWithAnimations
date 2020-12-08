package com.inspirecoding.recyclerviewsortedsectionswithanimations

import android.app.LauncherActivity

/**
 * List items used in [BaseViewHolder]. Implement this with items containing data to display
 * */
interface BaseItem {
    val layoutId: Int

    // Used to compare items when diffing so RecyclerView knows how to animate
    val uniqueId: Any

    /**
     * @param itemClickCallback Optional click callback for clicks on the whole item
     * */
    fun bind(holder: BaseViewHolder, itemClickCallback: ((BaseItem) -> Unit)?)

    // Make sure implementations implement equals function (data classes do already)
    override fun equals(other: Any?): Boolean
}