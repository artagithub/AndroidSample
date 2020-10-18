package com.sematec.basic.api

import com.example.entities.MovieDetailEntity
import com.example.entities.Search
import com.example.login.LoginRequestEntity
import com.example.model.Token
import retrofit2.Call
import retrofit2.http.*

interface Api {

    @GET( "http://www.omdbapi.com/?apikey=828e59af")
    fun getMovies(
        // @Path("api_version") apiVersion: String
        @Query("s") word: String,
        @Query("page") page: Int
    ): Call<MovieDetailEntity>


    @GET("http://www.omdbapi.com/")
    fun getAllMovies(
        // @Path("api_version") apiVersion: String
        @Query("key") key: String,
        @Query("q") word: String
    ): Call<Search>


    @POST("https://dev-o3tn3b4f.eu.auth0.com/oauth/token")
    fun login(
        @Body request: LoginRequestEntity
    ): Call<Token>

}