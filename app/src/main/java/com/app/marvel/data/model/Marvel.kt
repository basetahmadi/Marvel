package com.app.marvel.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

 //  ‌1 ساخت یک مدل از داده هایی که قراره بگیریم

@JsonClass(generateAdapter = true)
@Entity(tableName = "table_marvel")
data class Marvel(
    @PrimaryKey
    val name: String = "",
    @Json(name = "realname")
    val realName: String = "",
    val team: String = "",
    @Json(name = "firstappearance")
    val firstAppearance: String = "",
    @Json(name = "createdby")
    val createdBy: String = "",
    val publisher: String = "",
    @Json(name = "imageurl")
    val imageUrl: String = "",
    val bio: String = ""
)