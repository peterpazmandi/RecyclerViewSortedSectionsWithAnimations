package com.inspirecoding.recyclerviewsortedsectionswithanimations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var fruitListAdapter : BaseListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fruits = mutableListOf("Apple", "Banana", "Boysenberry", "Cherry", "Citron", "Körte", "Kávé", "Kiskanál", "Alma", "aaa")

        // Organise the fruit and add headers
        val fruitsWithAlphabetHeaders = createAlphabetizedFruit(fruits)

        // OMG this adapter can be used for anything without even touching it!
        fruitListAdapter = BaseListAdapter { fruitClicked ->

            // And removing items when we click them has a cool animation!
            fruits.remove((fruitClicked as? FruitItem?)?.name)
            fruitListAdapter.submitList(createAlphabetizedFruit(fruits))
        }

        recycler_view.adapter = fruitListAdapter

        // Now we have the list organised we can display it in one line!
        fruitListAdapter.submitList(fruitsWithAlphabetHeaders)
    }

    private fun createAlphabetizedFruit(fruits: List<String>): MutableList<BaseItem> {

        // Wrap data in list items
        val fruitItems = fruits.map { FruitItem(it) }.sortedBy { it.name }

        val fruitsWithAlphabetHeaders = mutableListOf<BaseItem>()

        // Loop through the fruit list and add headers where we need them
        var currentHeader: String? = null
        fruitItems.forEach { fruit ->
            fruit.name.firstOrNull()?.toString()?.let {
                if (it != currentHeader) {
                    fruitsWithAlphabetHeaders.add(HeaderItem(it))
                    currentHeader = it
                }
            }
            fruitsWithAlphabetHeaders.add(fruit)
        }
        return fruitsWithAlphabetHeaders
    }
}