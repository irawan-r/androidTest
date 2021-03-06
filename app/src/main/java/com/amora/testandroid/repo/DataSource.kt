package com.amora.testandroid.repo

import com.amora.testandroid.model.ResponseDetail
import com.amora.testandroid.model.ResponseItem

interface DataSource {
    suspend fun getTestAndroid(): List<ResponseItem?>?
    suspend fun getDetailTest(id: Int): ResponseDetail?
}