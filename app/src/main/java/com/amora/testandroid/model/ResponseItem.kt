package com.amora.testandroid.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResponseItem(

    @Json(name="id")
    val id: Int? = null,

    @Json(name="completed")
    val completed: Boolean? = null,

    @Json(name="title")
    val title: String? = null,

    @Json(name="userId")
    val userId: Int? = null
)