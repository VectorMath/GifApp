package com.eugenebaturov.gifapp

import android.content.Context
import com.eugenebaturov.gifapp.model.entities.Data
import com.eugenebaturov.gifapp.model.instance.RetrofitInstance
import com.eugenebaturov.gifapp.util.constants.LogsConstants.Companion.REPOSITORY_ERROR_MESSAGE
import retrofit2.Response

class AppRepository private constructor(context: Context) {

    suspend fun getGifList(): Response<Data> = RetrofitInstance.gifApi.getAllGif()

    suspend fun searchGif(q: String): Response<Data> = RetrofitInstance.gifApi.searchGif(q)

    companion object {

        private var INSTANCE: AppRepository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) INSTANCE = AppRepository(context)
        }

        fun getInstance(): AppRepository {
            return INSTANCE ?: throw IllegalStateException(REPOSITORY_ERROR_MESSAGE)
        }
    }
}