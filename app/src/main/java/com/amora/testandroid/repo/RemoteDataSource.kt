package com.amora.testandroid.repo

import com.amora.testandroid.api.ConfigApi
import com.amora.testandroid.model.AndroidResponse
import com.amora.testandroid.model.ResponseDetail
import com.amora.testandroid.model.ResponseItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource(
    private val apiConfig: ConfigApi,
) {

    companion object {

        @Volatile
        private var instance: RemoteDataSource? = null
        fun getInstance(api: ConfigApi): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(api)
            }
    }

    suspend fun getTestAndroid(callback: GetTestAndroid) {
        withContext(Dispatchers.IO) {
            val item = apiConfig.api.testAndroid().response
            callback.onAndroidReceived(item)
        }
    }

    suspend fun getDetailAndroid(id: Int, callback: GetDetailAndroid) {
        withContext(Dispatchers.IO) {
            val item = apiConfig.api.testDetail(id)
            callback.onDetailReceived(item)
        }
    }

    interface GetTestAndroid {
        fun onAndroidReceived(test: List<ResponseItem?>?)
    }

    interface GetDetailAndroid {
        fun onDetailReceived(test: ResponseDetail?)
    }
}
