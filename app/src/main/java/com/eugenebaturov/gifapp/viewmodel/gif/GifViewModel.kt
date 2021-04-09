package com.eugenebaturov.gifapp.viewmodel.gif

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eugenebaturov.gifapp.AppRepository
import com.eugenebaturov.gifapp.model.entities.Data
import com.eugenebaturov.gifapp.model.entities.Gif
import kotlinx.coroutines.launch
import retrofit2.Response

class GifViewModel(private val repository: AppRepository): ViewModel() {

    var gifs: MutableLiveData<Response<Data>> = MutableLiveData()

    fun getGifs() {
        viewModelScope.launch {
            val response = repository.getGifList()
            gifs.value = response
        }
    }

    fun searchGifs(q: String) {
        viewModelScope.launch {
            val response = repository.searchGif(q)
            gifs.value = response
        }
    }
}