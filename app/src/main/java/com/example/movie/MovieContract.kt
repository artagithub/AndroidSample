package com.example.movie

import com.example.data.MovieEntity
import com.example.entities.MovieDetailEntity
import com.example.entities.Search

class MovieContract {

    interface Presenter {
        fun searchMovie(word:String,page:Int)
        fun likeMovie(message:String)
    }


    interface View {
        fun onSearchSuccess(movieDetail:MovieDetailEntity)
        fun onSearchFailded(message: String?)
        fun onLikeMovieSuccess(message:String)
    }

    interface Model {
        fun saveMovie(movie:Search)
    }
}