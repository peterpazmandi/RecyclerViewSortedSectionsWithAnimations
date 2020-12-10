package com.inspirecoding.recyclerviewsortedsectionswithanimations

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.inspirecoding.recyclerviewsortedsectionswithanimations.databinding.ActivityMainBinding
import com.inspirecoding.recyclerviewsortedsectionswithanimations.databinding.LayoutDialogBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG = this.javaClass.simpleName

    private lateinit var fruitListAdapter : BaseListAdapter
    private lateinit var binding : ActivityMainBinding


    val fruits = mutableListOf("Apple", "Banana", "Boysenberry", "Cherry", "Citron", "Korte", "Kave", "Kiskanal", "Alma", "aaa")
//    val fruits = mutableListOf("Alma", "aaa")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        // Organise the fruit and add headers
        val fruitsWithAlphabetHeaders = createAlphabetizedFruit(fruits)

        // OMG this adapter can be used for anything without even touching it!
        fruitListAdapter = BaseListAdapter { fruitClicked ->

            // And removing items when we click them has a cool animation!
            fruits.remove((fruitClicked as? FruitItem?)?.name)
            val newList = createAlphabetizedFruit(fruits)
            fruitListAdapter.submitList(newList)
        }


        recycler_view.adapter = fruitListAdapter

        // Now we have the list organised we can display it in one line!
        fruitListAdapter.submitList(fruitsWithAlphabetHeaders)


        addItemsToList("Aaa")
        addItemsToList("Aba")
        addItemsToList("Aca")
        addItemsToList("Kkk")
        addItemsToList("Klk")
        addItemsToList("Mnc")
    }

    private fun createAlphabetizedFruit(fruits: List<String>): MutableList<BaseItem<*>> {

        // Wrap data in list items
        val fruitItems = fruits.map { FruitItem(it) }.sortedBy { it.name }

        val fruitsWithAlphabetHeaders = mutableListOf<BaseItem<*>>()

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


    private fun addItemsToList(newFruit: String) {
        fruits.add(newFruit)
        val newList = createAlphabetizedFruit(fruits)
        Log.d(TAG, "$newList")
        fruitListAdapter.submitList(newList)
    }

    private fun openDialog() {

        val builder = AlertDialog.Builder(this)        
        val dialogBinding = LayoutDialogBinding.inflate(layoutInflater)
        builder.setTitle("Add new fruit!")
        builder.setView(dialogBinding.root)
        builder.setPositiveButton(android.R.string.ok) {  dialogInterface, which ->
            if(dialogBinding.etNewFruit.text.toString().isNotEmpty()) {
                val newFruit = dialogBinding.etNewFruit.text.toString()
                Log.d(TAG, newFruit)
                addItemsToList(newFruit)
            }
            dialogInterface.dismiss()
        }
        builder.show()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.item_add -> {
                openDialog()
            }
        }

        return super.onOptionsItemSelected(item)
    }
}