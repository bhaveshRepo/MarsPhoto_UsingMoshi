package com.example.marsphotopractice

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marsphotopractice.api.ApiRequest
import com.example.marsphotopractice.model.MarsPhoto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MarsViewModel : ViewModel() {

    private val _photos = MutableLiveData<List<MarsPhoto>>()
    val photos : LiveData<List<MarsPhoto>> = _photos

    init {
        getMarsPhoto()
    }

    private fun getMarsPhoto(){
        viewModelScope.launch {
            try {
            _photos.value = ApiRequest.api.getPhotos()
            } catch (e : Exception){

            }
        }
    }

}