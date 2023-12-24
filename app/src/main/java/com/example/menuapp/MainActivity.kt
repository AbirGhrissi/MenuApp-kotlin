package com.example.menuapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val categories = arrayOf("Appetizers", "Main Course", "Desserts","Beverages" ,"Breakfast","Sandwiches","Salads","Seafood")

        val listView = findViewById<ListView>(R.id.categoriesListView)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, categories)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedCategory = categories[position]
            val intent = Intent(this, ItemsActivity::class.java)
            intent.putExtra("category", selectedCategory)
            startActivity(intent)
        }
    }
}
