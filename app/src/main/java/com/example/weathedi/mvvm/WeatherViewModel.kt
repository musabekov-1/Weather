package com.example.weathedi.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.weathedi.remote.Weather
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val repository: Repository):ViewModel() {
    fun getLiveWeather(city:String):LiveData<Weather>{
        return repository.getWeather(city)
    }
}