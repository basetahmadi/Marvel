package com.app.marvel.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.app.marvel.data.model.Marvel

@Dao
interface MarvelDao {

    @Insert
    suspend fun insert(item: Marvel)

    @Insert
    suspend fun insertAll(list: List<Marvel>)

    @Query("select * from table_marvel")
    fun getAll(): LiveData<List<Marvel>>

    @Query("delete from table_marvel")
    suspend fun clear()
}