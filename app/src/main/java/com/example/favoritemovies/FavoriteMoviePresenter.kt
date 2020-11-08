package com.example.favoritemovies

import com.example.data.MovieEntity

class FavoriteMoviePresenter(val view: FavoritesContract.View):FavoritesContract.Presenter {

    lateinit var model:FavoritesContract.Model;
    init {
        model = FavoriteMovieModel(this)
    }

    override fun loadAllMovies() {
        model.loadFavorites()
    }

    override fun loadMoviesSuccess(allMovies: List<MovieEntity>) {
        view.onLoadMovies(allMovies)
    }


}