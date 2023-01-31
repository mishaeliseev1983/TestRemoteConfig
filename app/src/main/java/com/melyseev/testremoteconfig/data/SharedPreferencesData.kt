package com.melyseev.cocktails2023.data

import android.content.SharedPreferences
import androidx.core.content.edit

const val  url = "URL"
class SharedPreferencesData(private val data: SharedPreferences) {

    fun getUrl(): String {
        return data.getString(url, "") ?:""
    }

    fun changeUrl(newUrl: String) {
        data.edit {
            putString(url, newUrl)
        }
    }
}