package com.example.listify.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.listify.data.db.model.ListItem

@Dao
interface ItemsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ListItem)

    @Delete
    suspend fun delete(item: ListItem)

    @Query("SELECT * FROM items")
    suspend fun getAllItems(): LiveData<List<ListItem>>
}