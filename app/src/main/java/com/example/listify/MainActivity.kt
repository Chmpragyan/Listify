package com.example.listify

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.listify.data.db.ShoppingItemsDatabase
import com.example.listify.data.repository.ShoppingRepository
import com.example.listify.ui.shoppingList.ShoppingItemsVMFactory
import com.example.listify.ui.shoppingList.ShoppingItemsViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val database = ShoppingItemsDatabase(this)
        val repository = ShoppingRepository(database)
        val factory = ShoppingItemsVMFactory(repository)

        val registerViewModel: ShoppingItemsViewModel by viewModels {
            factory
        }
    }
}