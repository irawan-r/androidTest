package com.amora.testandroid.model

import com.squareup.moshi.Json

data class AndroidResponse(

    @Json(name = "AndroidResponse")
    val response: List<ResponseItem?>?,
)
