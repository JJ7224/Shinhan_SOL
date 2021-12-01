package com.example.shinhan_sol

import android.app.Application

class App : Application() {
    companion object {
        lateinit var prefs: SharedPreference
    }
    override fun onCreate() {
        prefs = SharedPreference(applicationContext)
        super.onCreate()
    }
}