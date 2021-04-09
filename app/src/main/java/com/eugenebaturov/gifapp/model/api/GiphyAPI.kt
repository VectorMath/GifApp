package com.eugenebaturov.gifapp.model.api

import com.eugenebaturov.gifapp.model.entities.Data
import com.eugenebaturov.gifapp.model.entities.Gif
import com.eugenebaturov.gifapp.util.constants.GiphyConstants
import com.eugenebaturov.gifapp.util.constants.GiphyConstants.Companion.GIFS_URL
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GiphyAPI {

    @GET(value = GIFS_URL)
    suspend fun getAllGif(): Response<Data>

    @GET("./search?api_key=${GiphyConstants.GIPHY_API_KEY}&limit=25&offset=0&rating=g&lang=en")
    suspend fun searchGif(@Query("q") q: String): Response<Data>
}