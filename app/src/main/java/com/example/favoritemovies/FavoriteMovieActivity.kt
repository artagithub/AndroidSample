package com.example.favoritemovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.adapters.MovieAdapter
import com.example.data.MovieEntity
import com.example.entities.MovieDetailEntity
import com.example.entities.Search
import com.example.service.R
import com.loopj.android.http.AsyncHttpClient
import com.sematec.basic.utils.log
import com.sematec.basic.utils.toast
import kotlinx.android.synthetic.main.activity_favorite_movies.*
import kotlinx.android.synthetic.main.activity_movie_search_engine.*

class FavoriteMovieActivity : AppCompatActivity(), FavoritesContract.View  {

    //val url = "https://pixabay.com/api/?key=14649220-5ae78e4612f86b869152790a4&q="
    val url = "http://www.omdbapi.com/?apikey=828e59af&s="

    lateinit var presenter:FavoritesContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite_movies)
        presenter = FavoriteMoviePresenter(this)

        presenter.loadAllMovies()



    }

    override fun onLoadMovies(allMovies: List<MovieEntity>) {
        val favoriteMovieAdapter = FavoriteMovieAdapter(this, allMovies.toMutableList())
        favorites.adapter = favoriteMovieAdapter
    }


}