package com.app.marvel.data.remote

import com.app.marvel.data.model.Marvel
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

object MarvelApiService {
    val api: MarvelApi = Network.retrofit.create(MarvelApi::class.java)
}

interface MarvelApi {

    @GET("demos/marvel/")
    fun getMarvelFromRemoteAsync(): Deferred<List<Marvel>>

}