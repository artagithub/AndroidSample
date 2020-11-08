package com.example.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.data.MovieEntity

@Dao
interface MovieDao {
    @Query("SELECT * FROM movie_table")
    fun getAll(): List<MovieEntity>

    @Query("SELECT * FROM movie_table WHERE id IN (:bookID)")
    fun loadAllByIds(bookID: IntArray): List<MovieEntity>

    @Query("SELECT * FROM movie_table WHERE title LIKE :title LIMIT 1")
    fun findByName(title: String): MovieEntity

    @Query("DELETE FROM movie_table")
    fun deleteAll()

    @Insert
    fun insertAll(vararg books: MovieEntity)

    @Delete
    fun delete(book: MovieEntity)

}