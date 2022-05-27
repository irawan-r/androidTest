package com.amora.testandroid.di

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.amora.testandroid.api.ConfigApi
import com.amora.testandroid.base.viewmodel.ViewModelFactory
import com.amora.testandroid.repo.RemoteDataSource
import com.amora.testandroid.repo.Repository


object Injection {
    fun provideRepository(context: Context): Repository {
        val api = ConfigApi
        val remoteDataSource = RemoteDataSource.getInstance(api)

        return Repository.getInstance(remoteDataSource)
    }
}