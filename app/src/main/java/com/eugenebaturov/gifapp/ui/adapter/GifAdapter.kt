package com.eugenebaturov.gifapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.eugenebaturov.gifapp.R
import com.eugenebaturov.gifapp.model.entities.Gif

class GifAdapter(var gifs: List<Gif>, var context: Context) :
    RecyclerView.Adapter<GifAdapter.GifHolder>() {

    inner class GifHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private lateinit var gif: Gif

        private var gifImageView: ImageView = itemView.findViewById(R.id.gif)
        private val gifTitleTextView: TextView = itemView.findViewById(R.id.title)

        fun bind(gif: Gif) {

            this.gif = gif
            Glide.with(itemView).asGif().load(this.gif.url).into(gifImageView)
            gifTitleTextView.text = this.gif.slug
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifHolder {
        val view = LayoutInflater
            .from(context)
            .inflate(R.layout.list_gif_item, parent, false)

        return GifHolder(view)
    }

    override fun getItemCount(): Int = gifs.size

    override fun onBindViewHolder(holder: GifHolder, position: Int) {
        val gif = gifs[position]
        holder.bind(gif)
    }
}

