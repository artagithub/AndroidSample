package com.example.service

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.adapters.MovieAdapter
import com.example.entities.MovieDetailEntity
import com.example.entities.Search
import com.google.gson.Gson
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.TextHttpResponseHandler
import com.sematec.basic.utils.log
import com.sematec.basic.utils.toast
import cz.msebera.android.httpclient.Header
import kotlinx.android.synthetic.main.activity_movie_search_engine.*

class MovieSearchEngineActivity : AppCompatActivity() {

    //val url = "https://pixabay.com/api/?key=14649220-5ae78e4612f86b869152790a4&q="
    val url = "http://www.omdbapi.com/?apikey=828e59af&s="

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_search_engine)

        search.setOnClickListener {
            searchImage(word.text.toString())
        }
    }

    private fun searchImage(word: String) {

        val client = AsyncHttpClient()
        val restURL = "$url$word&page=1"
        restURL.log("omdbapi_result")


        client.get(restURL, object : TextHttpResponseHandler() {
            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>?,
                responseString: String?
            ) {
                parseResult(responseString)
                responseString?.log("omdbapi_result")
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>?,
                responseString: String?,
                throwable: Throwable?
            ) {

            }

        })

    }

    private fun parseResult(serverResults: String?) {
        val gson = Gson()
        val movieDetailEntity = gson.fromJson(
            serverResults,
            MovieDetailEntity::class.java
        )

        if (movieDetailEntity.totalResults.toInt() == 0) {
            "No results from server".toast()
            return
        } else {

            val movies = movieDetailEntity.search.take(10)

            val adapter = MovieAdapter(this, movies as MutableList<Search>)
            results.adapter = adapter
        }

    }
}