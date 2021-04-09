package com.eugenebaturov.gifapp.viewmodel.gif

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.eugenebaturov.gifapp.AppRepository

class GifViewModelFactory(private val repository: AppRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return GifViewModel(repository) as T
    }
}