package com.app.marvel.data

import androidx.lifecycle.LiveData
import com.app.marvel.data.database.MarvelDao
import com.app.marvel.data.model.Marvel
import com.app.marvel.data.remote.MarvelApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import java.lang.Exception

class MarvelRepository(
    private val localDataSource: MarvelDao,
    private val remoteDataSource: MarvelApi
) {
    suspend fun refreshMarvelList(): Boolean {
        return try {
            val result = remoteDataSource.getMarvelFromRemoteAsync().await()
            refreshLocalDataSource(result)
            true
        } catch (e: Exception) {
            Timber.e(e)
            false
        }
    }

    private suspend fun refreshLocalDataSource(marvelList: List<Marvel>) =
        withContext(Dispatchers.IO) {
            localDataSource.clear()
            localDataSource.insertAll(marvelList)
        }

    fun observeList(): LiveData<List<Marvel>> = localDataSource.getAll()
}