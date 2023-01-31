package com.melyseev.testremoteconfig.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.melyseev.cocktails2023.data.SharedPreferencesData
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val sharedPreferences: SharedPreferencesData
) : ViewModel() {

    private var _liveData = MutableLiveData<String>()
    val liveData: LiveData<String> = _liveData


    fun readLocalUrl(){
        _liveData.postValue(sharedPreferences.getUrl())
    }

    fun resetUrl(){
        sharedPreferences.changeUrl("")
    }

    fun writeUrl(newUrl: String){
        sharedPreferences.changeUrl(newUrl)
    }
}