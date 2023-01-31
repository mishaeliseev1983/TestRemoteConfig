package com.melyseev.testremoteconfig.di

import android.content.Context
import com.melyseev.testremoteconfig.App
import dagger.Module
import dagger.Provides

@Module
object AppModule {

    @ApplicationScope
    @Provides
    fun provideApplication(app: Context): App {
        return app as App
    }

}