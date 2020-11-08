package com.example.movie

import com.example.entities.MovieDetailEntity
import com.example.entities.Search
import com.sematec.basic.api.WebService
import com.sematec.basic.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviePresenter(val view: MovieContract.View) : MovieContract.Presenter {




    override fun searchMovie(word: String, page: Int) {

        val apiCall = WebService.api.getMovies(
            word = word,
            page = page
        ).enqueue(object : Callback<MovieDetailEntity> {
            override fun onResponse(call: Call<MovieDetailEntity>, response: Response<MovieDetailEntity>) {
                view.onSearchSuccess(response.body() as MovieDetailEntity)
//                view.onLoading(false)
            }

            override fun onFailure(call: Call<MovieDetailEntity>, t: Throwable) {
                view.onSearchFailded(t.message)
//                view.onLoading(false)
            }

        })

    }

    override fun likeMovie(movieDetail: Search) {
        TODO("Not yet implemented")
    }


}