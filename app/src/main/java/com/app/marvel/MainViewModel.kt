package com.app.marvel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.marvel.data.MarvelRepository
import com.app.marvel.data.database.MarvelDao
import com.app.marvel.data.model.Marvel
import com.app.marvel.data.remote.MarvelApiService
import kotlinx.coroutines.*
import timber.log.Timber
import java.lang.Exception

class MainViewModel(repository: MarvelRepository) : ViewModel() {

    private val viewModelScope = CoroutineScope(Dispatchers.Main)

    val marvelList: LiveData<List<Marvel>> = repository.observeList()

    init {
        viewModelScope.launch {
            repository.refreshMarvelList()
        }
    }
}

class MainViewModelFactory(private val repository: MarvelRepository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}