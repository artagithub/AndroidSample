package com.example.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "movie_table")
data class MovieEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "title") val title: String?,
    @ColumnInfo(name = "year") val year: String?,
    @ColumnInfo(name = "imdbID") val imdbID: String?,
    @ColumnInfo(name = "Type") val Type: String?,
    @ColumnInfo(name = "Poster") val Poster: String?
)