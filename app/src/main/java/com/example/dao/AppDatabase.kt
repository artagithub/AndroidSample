package com.example.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.MovieEntity

@Database(entities = arrayOf(MovieEntity::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDAO(): MovieDao
}
