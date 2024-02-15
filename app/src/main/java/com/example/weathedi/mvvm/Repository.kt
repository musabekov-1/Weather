package com.example.weathedi.mvvm

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.weathedi.remote.Weather
import com.example.weathedi.remote.WeatherApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val api:WeatherApi){
    fun getWeather(city:String):MutableLiveData<Weather>{
        val weather = MutableLiveData<Weather>()
        api.getWeather(city = city).enqueue(object : Callback<Weather>{
            override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
                if (response.isSuccessful){
                    response.body()?.let {
                        weather.postValue(it)
                    }
                }
            }

            override fun onFailure(call: Call<Weather>, t: Throwable) {
                Log.d("onFailure", "data hasn't come")
            }
        })
        return weather
    }
}