package com.example.favoritemovies

import com.sematec.basic.utils.MyApplication

class FavoriteMovieModel(val presenter: FavoritesContract.Presenter):FavoritesContract.Model {
    override fun loadFavorites() {
        val allMovies = MyApplication.roomDB.movieDAO().getAll()
        presenter.loadMoviesSuccess(allMovies)
    }
}