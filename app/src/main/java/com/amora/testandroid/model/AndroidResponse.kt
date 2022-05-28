package com.amora.testandroid.model

import com.squareup.moshi.*

data class AndroidResponse(

    @Json(name = "AndroidResponse")
    val response: List<ResponseItem?>?,
)
