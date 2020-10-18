package com.example.movie

import com.example.entities.MovieDetailEntity
import com.example.entities.Search

class MovieContract {

    interface Presenter {
        fun searchMovie(word:String,page:Int)
    }


    interface View {
        fun onSearchSuccess(movieDetail:MovieDetailEntity)
        fun onSearchFailded(message: String?)
    }
}