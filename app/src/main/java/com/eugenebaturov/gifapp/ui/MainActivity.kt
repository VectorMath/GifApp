package com.eugenebaturov.gifapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.eugenebaturov.gifapp.AppRepository
import com.eugenebaturov.gifapp.R
import com.eugenebaturov.gifapp.model.entities.Gif
import com.eugenebaturov.gifapp.ui.adapter.GifAdapter
import com.eugenebaturov.gifapp.util.constants.GiphyConstants.Companion.GIPHY_API_KEY
import com.eugenebaturov.gifapp.util.constants.LogsConstants.Companion.TAG_RESPONSE
import com.eugenebaturov.gifapp.viewmodel.gif.GifViewModel
import com.eugenebaturov.gifapp.viewmodel.gif.GifViewModelFactory
import com.giphy.sdk.ui.Giphy
import com.giphy.sdk.ui.views.GiphyDialogFragment

class MainActivity : AppCompatActivity() {

    private lateinit var searchView: SearchView
    private lateinit var gifRecyclerView: RecyclerView
    private lateinit var adapter: GifAdapter

    private lateinit var gifViewModel: GifViewModel
    private lateinit var gifViewModelFactory: GifViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialize()
    }

    override fun onStart() {
        super.onStart()

        gifViewModel.getGifs()
        gifViewModel.gifs.observe(this, Observer { response ->
           if (response.isSuccessful) {
               val gifs = response.body()!!
               Log.d(TAG_RESPONSE, response.body().toString())
               setAdapter(gifs.data)
           } else {
               Log.e(TAG_RESPONSE, response.errorBody().toString())
           }
        })
    }

    private fun initialize() {

        searchView = findViewById(R.id.search_view)

        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                gifViewModel.searchGifs(searchView.query.toString())
                searchView.clearFocus()
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })

        gifRecyclerView = findViewById(R.id.rv_gif)
        gifRecyclerView.layoutManager = LinearLayoutManager(this)
        gifRecyclerView.hasFixedSize()

        val repository = AppRepository.getInstance()
        gifViewModelFactory = GifViewModelFactory(repository)

        gifViewModel = ViewModelProvider(this, gifViewModelFactory)
            .get(GifViewModel::class.java)
    }

    private fun setAdapter(gifs: List<Gif>) {
        adapter = GifAdapter(gifs, this)
        gifRecyclerView.adapter = adapter

        Log.d(TAG_RESPONSE, gifs[0].url)
    }
}