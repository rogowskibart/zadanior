package com.rogowskibart.zadanior

import android.app.Application
import com.rogowskibart.zadanior.database.AppDatabase

class App : Application() {
    val database by lazy { AppDatabase.open(this) }

    override fun onCreate() {
        super.onCreate()
        database
    }
}