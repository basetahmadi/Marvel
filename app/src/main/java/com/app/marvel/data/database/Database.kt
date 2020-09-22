package com.app.marvel.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.marvel.data.model.Marvel

@Database(
    entities = [Marvel::class],
    version = 1,
    exportSchema = false
)
abstract class Database : RoomDatabase() {
    abstract fun marvelDao(): MarvelDao
}