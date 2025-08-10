package com.example.listify.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.listify.data.db.model.ShoppingItem

@Database(
    entities = [ShoppingItem::class],
    version = 1
)
abstract class ShoppingItemsDatabase : RoomDatabase() {
    abstract fun getItemsDao(): ShoppingItemsDao

    companion object {
        @Volatile
        private var instance: ShoppingItemsDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context): ShoppingItemsDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                ShoppingItemsDatabase::class.java,
                "ItemDB.db"
            ).build()
        }
    }
}