package com.amora.testandroid.repo

import com.amora.testandroid.model.ResponseDetail
import com.amora.testandroid.model.ResponseItem

class Repository private constructor(
    private val remoteDataSource: RemoteDataSource
): DataSource {
    companion object {
        @Volatile
        private var instance: Repository? = null
        fun getInstance(remoteData: RemoteDataSource): Repository =
            instance ?: synchronized(this) {
                instance ?: Repository(remoteData)
            }
    }

    override suspend fun getTestAndroid(): List<ResponseItem?>? {
        var androidList: List<ResponseItem?>? = null
        remoteDataSource.getTestAndroid(object : RemoteDataSource.GetTestAndroid {
            override fun onAndroidReceived(test: List<ResponseItem?>?) {
                androidList = test
            }
        })
        return androidList
    }

    override suspend fun getDetailTest(id: Int): ResponseDetail? {
        var androidList: ResponseDetail? = null
        remoteDataSource.getDetailAndroid(id, object : RemoteDataSource.GetDetailAndroid {
            override fun onDetailReceived(test: ResponseDetail?) {
                androidList = test
            }
        })
        return androidList
    }

}


