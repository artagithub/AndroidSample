package com.example.movie

import com.example.data.MovieEntity
import com.example.entities.Search
import com.google.gson.internal.`$Gson$Preconditions`
import com.sematec.basic.utils.MyApplication

class MovieModel(val presenter: MoviePresenter):MovieContract.Model  {
    override fun saveMovie(movie: Search) {
        val convertDtoToEntity = convertDtoToEntity(movie)
        MyApplication.roomDB.movieDAO().insertAll(convertDtoToEntity)
        presenter.likeMovie("You add a favorite movie!!")
    }

    fun convertDtoToEntity(movieDto: Search):MovieEntity{
       return MovieEntity(1,movieDto.title,movieDto.year,movieDto.imdbID,movieDto.type,movieDto.poster)
    }
}