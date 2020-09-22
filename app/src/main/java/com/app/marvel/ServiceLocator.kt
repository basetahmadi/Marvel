package com.app.marvel

import android.content.Context
import androidx.room.Room
import com.app.marvel.data.MarvelRepository
import com.app.marvel.data.database.Database
import com.app.marvel.data.remote.MarvelApiService

object ServiceLocator {
    private var database: Database? = null

    fun provideRepository(context: Context): MarvelRepository {
        return MarvelRepository(
            provideDatabase(context).marvelDao(),
            MarvelApiService.api
        )
    }

    private fun provideDatabase(context: Context): Database {
        synchronized(this) {
            return database ?: createDatabase(context)
        }

    }

    private fun createDatabase(context: Context): Database {
        return Room.databaseBuilder(
            context,
            Database::class.java,
            "MotivationDatabase"
        ).fallbackToDestructiveMigration()
            .build().also {
                database = it
            }
    }

}