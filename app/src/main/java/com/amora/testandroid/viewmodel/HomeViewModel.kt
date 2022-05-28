package com.amora.testandroid.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amora.testandroid.api.ConfigApi
import com.amora.testandroid.model.ResponseItem
import com.amora.testandroid.repo.Repository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel(
    private val repository: Repository,
) : ViewModel() {

    private val _testAndroid = MutableLiveData<List<ResponseItem?>?>()
    val testAndroid: LiveData<List<ResponseItem?>?> = _testAndroid

    init {
        getTestAndroid()
    }

    private fun getTestAndroid() {
        viewModelScope.launch {
            try {
                _testAndroid.value = repository.getTestAndroid()
            } catch (e: Throwable) {
                e.printStackTrace()
            }
        }
    }
}
