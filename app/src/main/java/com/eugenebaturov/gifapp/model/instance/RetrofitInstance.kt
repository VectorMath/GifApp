package com.eugenebaturov.gifapp.model.instance

import com.eugenebaturov.gifapp.model.api.GiphyAPI
import com.eugenebaturov.gifapp.util.constants.GiphyConstants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val gifApi: GiphyAPI by lazy {
        retrofit.create(GiphyAPI::class.java)
    }
}