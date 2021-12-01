package com.example.shinhan_sol

import android.content.Context

class SharedPreference(context: Context) {
    private val SharedPreferenceNm = "mPref"
    private val SharedPreference = context.getSharedPreferences(SharedPreferenceNm,
        Context.MODE_PRIVATE)

    var token: String?
        get() = SharedPreference.getString("token", null)
        set(value) {
            SharedPreference.edit().putString("token", value).apply()
        }

}