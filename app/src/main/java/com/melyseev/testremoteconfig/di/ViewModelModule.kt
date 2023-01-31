package com.melyseev.testremoteconfig.di

import androidx.lifecycle.ViewModel
import com.melyseev.testremoteconfig.presentation.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @IntoMap
    @ViewModelKey(MainViewModel::class)
    @Binds
    fun bindMainViewModel(impl: MainViewModel): ViewModel
}