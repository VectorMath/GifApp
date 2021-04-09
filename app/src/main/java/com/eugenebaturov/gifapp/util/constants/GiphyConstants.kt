package com.eugenebaturov.gifapp.util.constants

class GiphyConstants {

    companion object {

        const val GIPHY_API_KEY = "0CCRJK86QJaiuc7spu8WgWPCGb1D0Olh"
        const val BASE_URL = "https://api.giphy.com/v1/gifs/"
        const val GIFS_URL = "./trending?api_key=${GIPHY_API_KEY}&limit=25&rating=g"
    }
}