package com.eugenebaturov.gifapp.model.entities

data class Gif(
    val slug: String,
    val images: Images
)

data class Data(
    var data: List<Gif>
)

data class Images(
    val original: Original
)

data class Original(
    val url: String
)