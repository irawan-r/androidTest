package com.amora.testandroid.api

import com.amora.testandroid.model.Response
import com.amora.testandroid.model.ResponseDetail
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("todos")
    suspend fun testAndroid(): Response

    @GET("todos/{id}")
    suspend fun testDetail(@Path("id") id: Int): ResponseDetail
}
