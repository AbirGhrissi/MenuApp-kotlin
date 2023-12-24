package com.example.menuapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.view.ViewGroup


class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)

        val category = intent.getStringExtra("category")

        val itemsMap = mapOf(
            "Appetizers" to mapOf(
                "Salad" to 5.99, "Soup" to 4.99, "Bruschetta" to 6.49, "Shrimp Cocktail" to 8.99,
                "Garlic Bread" to 3.99, "Spring Rolls" to 5.49, "Calamari" to 7.99, "Nachos" to 6.99
            ),
            "Main Course" to mapOf(
                "Steak" to 15.99, "Pasta" to 12.99, "Chicken" to 11.49, "Fish" to 14.99,
                "Burger" to 9.99, "Pizza" to 10.49, "Tacos" to 8.99, "Sushi" to 16.49
            ),
            "Desserts" to mapOf(
                "Cake" to 6.99, "Ice Cream" to 4.99, "Fruit Salad" to 5.49, "Cheesecake" to 7.99,
                "Pudding" to 3.99, "Cupcakes" to 4.49, "Tiramisu" to 8.99, "Brownies" to 5.99
            ),
            "Beverages" to mapOf(
                "Water" to 1.99, "Soda" to 2.49, "Juice" to 3.49, "Coffee" to 2.99,
                "Tea" to 2.29, "Beer" to 4.99, "Wine" to 6.99, "Cocktails" to 7.49
            ),
            "Breakfast" to mapOf(
                "Pancakes" to 7.99, "Waffles" to 6.49, "Omelette" to 8.99, "French Toast" to 6.99,
                "Bagel" to 3.99, "Croissant" to 4.49, "Granola" to 5.99, "Yogurt Parfait" to 4.99
            ),
            "Sandwiches" to mapOf(
                "BLT Sandwich" to 9.99, "Club Sandwich" to 10.99, "Grilled Cheese" to 6.99, "Panini" to 8.49,
                "Reuben Sandwich" to 11.99, "Philly Cheesesteak" to 12.49, "Turkey Sandwich" to 7.99, "Tuna Sandwich" to 8.99
            ),
            "Salads" to mapOf(
                "Caesar Salad" to 7.49, "Greek Salad" to 8.99, "Cobb Salad" to 9.99, "Caprese Salad" to 6.99,
                "Nicoise Salad" to 10.49, "Waldorf Salad" to 7.99, "Spinach Salad" to 6.49, "Asian Chicken Salad" to 8.99
            ),
            "Seafood" to mapOf(
                "Lobster" to 29.99, "Crab" to 24.99, "Shrimp Scampi" to 18.99, "Fish Tacos" to 14.99,
                "Grilled Salmon" to 22.99, "Sushi Platter" to 25.99, "Clam Chowder" to 12.99, "Oysters" to 19.99
            )
            // Add more categories and their respective items with costs
        )



        val itemsWithCost = itemsMap[category] ?: emptyMap()
        val itemList = itemsWithCost.toList()

        val listView = findViewById<ListView>(R.id.itemsListView)
        val adapter = object : ArrayAdapter<Pair<String, Double>>(
            this,
            android.R.layout.simple_list_item_1,
            itemList
        ) {
            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val view = super.getView(position, convertView, parent)
                val textView1 = view.findViewById<TextView>(android.R.id.text1)
                textView1.setTextColor(Color.WHITE) // Change text color to white
                return view
            }
        }
        listView.adapter = adapter



        val returnButton = findViewById<Button>(R.id.returnButton)
        returnButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}