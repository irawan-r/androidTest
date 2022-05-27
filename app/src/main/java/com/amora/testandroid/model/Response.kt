package com.amora.testandroid.model

import com.squareup.moshi.Json

data class Response(

	@Json(name="Response")
	val response: List<ResponseItem?>? = null
)
