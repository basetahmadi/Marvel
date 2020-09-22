package com.app.marvel

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.app.marvel.data.MarvelRepository

class MarvelWorker(appContext: Context, params: WorkerParameters) : CoroutineWorker(
    appContext,
    params
) {
    companion object {
        const val WORK_NAME = "com.app.marvel.MarvelWorker"
    }

    override suspend fun doWork(): Result {
        val repository: MarvelRepository = ServiceLocator.provideRepository(applicationContext)
        return if (repository.refreshMarvelList())
            Result.success()
        else
            Result.retry()
    }
}