package com.example.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.entities.MovieDetailEntity
import com.example.entities.Search
import com.example.service.R
import com.loopj.android.http.AsyncHttpClient
import com.sematec.basic.utils.log
import com.sematec.basic.utils.toast
import kotlinx.android.synthetic.main.activity_movie_search_engine.*

class MovieSearchEngineActivity : AppCompatActivity(), MovieContract.View  {

    //val url = "https://pixabay.com/api/?key=14649220-5ae78e4612f86b869152790a4&q="
    val url = "http://www.omdbapi.com/?apikey=828e59af&s="

    lateinit var presenter:MovieContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_search_engine)
        supportActionBar?.hide()
        presenter = MoviePresenter(this)
        search.setOnClickListener {
            searchImage(word.text.toString())
        }

    }

    private fun searchImage(word: String) {

        val client = AsyncHttpClient()
        val restURL = "$url$word&page=1"
        restURL.log("omdbapi_result")

        val result = presenter.searchMovie(word,1)



//        client.get(restURL, object : TextHttpResponseHandler() {
//            override fun onSuccess(
//                statusCode: Int,
//                headers: Array<out Header>?,
//                responseString: String?
//            ) {
//                parseResult(responseString)
//                responseString?.log("omdbapi_result")
//            }
//
//            override fun onFailure(
//                statusCode: Int,
//                headers: Array<out Header>?,
//                responseString: String?,
//                throwable: Throwable?
//            ) {
//
//            }
//
//        })


    }

    override fun onSearchSuccess(movieDetailEntity: MovieDetailEntity) {
        if (movieDetailEntity.totalResults.toInt() == 0) {
            "No results from server".toast()
            return
        } else {

            val movies = movieDetailEntity.search.take(10)

            val adapter = MovieRecyclerAdapter(this, movies as MutableList<Search>)
            results.adapter = adapter
        }
    }

    override fun onSearchFailded(message: String?) {
        "Cant load images by retrofit!!".toast()
    }

    override fun onLikeMovieSuccess(message: String) {
        message.toast()
    }

//    override fun onLikeClicked(movieDetail: Search) {
//        presenter.likeMovie(movieDetail)
//    }


}