package com.example.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bumptech.glide.annotation.Excludes


@Entity(tableName = "movie_table")
data class MovieEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "title") val title: String?,
    @ColumnInfo(name = "year") val year: String?,
    @ColumnInfo(name = "imdbID") val imdbID: String?,
    @ColumnInfo(name = "Type") val type: String?,
    @ColumnInfo(name = "Poster") val poster: String?
)