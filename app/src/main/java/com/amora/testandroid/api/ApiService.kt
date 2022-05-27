package com.amora.testandroid.api

import com.amora.testandroid.model.AndroidResponse
import com.amora.testandroid.model.ResponseDetail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("todos")
    suspend fun testAndroid(): AndroidResponse

    @GET("todos/{id}")
    suspend fun testDetail(@Path("id") id: Int): ResponseDetail
}
