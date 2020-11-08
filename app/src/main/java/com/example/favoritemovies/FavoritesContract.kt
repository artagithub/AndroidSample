package com.example.favoritemovies

import com.example.data.MovieEntity

class FavoritesContract {


    interface Presenter {
        fun loadAllMovies()
        fun loadMoviesSuccess(allMovies: List<MovieEntity>)
    }

    interface View {
        fun onLoadMovies(allMovies: List<MovieEntity>)
    }

    interface Model {
        fun loadFavorites()
    }


}