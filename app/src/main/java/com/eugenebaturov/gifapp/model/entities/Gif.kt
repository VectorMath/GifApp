package com.eugenebaturov.gifapp.model.entities

data class Gif(
    val slug: String,
    val url: String
)

data class Data(
    var data: List<Gif>
)