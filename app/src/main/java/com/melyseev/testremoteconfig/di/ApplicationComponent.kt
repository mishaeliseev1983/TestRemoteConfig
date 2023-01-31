package com.melyseev.testremoteconfig.di

import android.content.Context
import com.melyseev.testremoteconfig.presentation.MainActivity
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        ViewModelModule::class,
        AppModule::class,
        SharedPreferencesModule::class])
interface ApplicationComponent {

    fun inject(activity: MainActivity)


    @Component.Factory
    interface AppCompFactory {
        fun create(
            @BindsInstance context: Context
        ): ApplicationComponent
    }
}