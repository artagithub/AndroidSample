package com.sematec.basic.utils

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.dao.AppDatabase
import com.orhanobut.hawk.Hawk

class MyApplication : Application() {

    companion object {
        lateinit var userNameFamily: String
        lateinit var context : Context
        lateinit var roomDB: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        Hawk.init(this).build()
        context = this
        userNameFamily = "AmirHossein Teymoori"
    }


    override fun onLowMemory() {
        super.onLowMemory()
    }

    override fun onTerminate() {
        super.onTerminate()
    }

    private fun initRoom() {
        roomDB = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "isc_room.sqlite"
        ).allowMainThreadQueries().build()
        //please don't use allowMainThreadQueries
        //use threads
    }
}