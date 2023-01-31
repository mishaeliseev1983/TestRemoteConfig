package com.melyseev.testremoteconfig.di

import android.content.Context
import android.content.SharedPreferences
import com.melyseev.cocktails2023.data.SharedPreferencesData
import dagger.Module
import dagger.Provides

@Module
class SharedPreferencesModule {

    @Provides
    fun getSharedData(app: Context): SharedPreferences {
        return app.getSharedPreferences("PREFERENCE_NAME111211111111", Context.MODE_PRIVATE)
    }

    @Provides
    fun provideSharedData(sharedPreferences: SharedPreferences): SharedPreferencesData {
        return SharedPreferencesData(sharedPreferences)
    }

}