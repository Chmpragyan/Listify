package com.example.listify

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [ListItem::class],
    version = 1
)
abstract class ItemDatabase : RoomDatabase() {
    abstract fun getItemsDao(): ItemsDao

    companion object {
        @Volatile
        private var instance: ItemDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context): ItemDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                ItemDatabase::class.java,
                "ItemDB.db"
            ).build()
        }
    }
}