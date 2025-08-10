package com.example.listify.data.repository

import com.example.listify.data.db.ItemDatabase
import com.example.listify.data.db.model.ListItem

class ShoppingRepository(private val db: ItemDatabase) {
    suspend fun  upsert(item: ListItem) = db.getItemsDao().upsert(item)

    suspend fun delete(item: ListItem )=  db.getItemsDao().delete(item)

    fun getAllShoppingItems() = db.getItemsDao().getAllItems()
}