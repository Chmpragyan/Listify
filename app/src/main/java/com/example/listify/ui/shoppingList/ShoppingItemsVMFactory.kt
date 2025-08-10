package com.example.listify.ui.shoppingList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.listify.data.repository.ShoppingRepository

class ShoppingItemsVMFactory(private val shoppingRepository: ShoppingRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ShoppingItemsViewModel::class.java)) {
            return ShoppingItemsVMFactory(shoppingRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}