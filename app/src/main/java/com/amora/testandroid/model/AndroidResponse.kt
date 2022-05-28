package com.amora.testandroid.model

import com.squareup.moshi.*

@JsonClass(generateAdapter = true)
data class AndroidResponse(

    @Json(name = "AndroidResponse")
    val response: List<ResponseItem?>?,
)
