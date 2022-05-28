package com.amora.testandroid.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amora.testandroid.model.ResponseDetail
import com.amora.testandroid.repo.Repository
import kotlinx.coroutines.launch

class DetailViewModel(
    private val repository: Repository,
) : ViewModel() {
    private val _detailAndroid = MutableLiveData<ResponseDetail?>()
    val detailAndroid: LiveData<ResponseDetail?> = _detailAndroid


    fun getTestAndroid(id: Int) {
        viewModelScope.launch {
            try {
                _detailAndroid.value = repository.getDetailTest(id)
            } catch (e: Throwable) {
                e.printStackTrace()
            }
        }
    }
}