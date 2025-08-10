package com.example.listify.ui.shoppingList

import com.example.listify.data.db.model.ShoppingItem
import com.example.listify.data.repository.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingItemsViewModel(private val shoppingRepository: ShoppingRepository) {
    fun upsert(items: ShoppingItem) {
        CoroutineScope(Dispatchers.Main).launch {
            shoppingRepository.upsert(items)
        }
    }

    fun delete(items: ShoppingItem) {
        CoroutineScope(Dispatchers.Main).launch {
            shoppingRepository.delete(items)
        }
    }

    fun getAllShoppingItems() = shoppingRepository.getAllShoppingItems()
}