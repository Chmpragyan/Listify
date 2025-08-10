package com.example.listify.data.repository

import com.example.listify.data.db.ShoppingItemsDatabase
import com.example.listify.data.db.model.ShoppingItem

class ShoppingRepository(private val db: ShoppingItemsDatabase) {
    suspend fun  upsert(item: ShoppingItem) = db.getItemsDao().upsert(item)

    suspend fun delete(item: ShoppingItem )=  db.getItemsDao().delete(item)

    fun getAllShoppingItems() = db.getItemsDao().getAllItems()
}