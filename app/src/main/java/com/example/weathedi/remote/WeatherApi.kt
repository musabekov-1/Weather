package com.example.weathedi.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface WeatherApi {
    @GET("forecast.json")
    fun getWeather(
        @Query("q") city:String,
        @Query("days") days:Int = 10,
        @Header("X-RapidAPI-Key") key:String = "7753737404msh1de34a18e6f9f85p107731jsne1168a9b8ff3",
        @Header("X-RapidAPI-Host") host:String = "weatherapi-com.p.rapidapi.com",
    ): Call<Weather>
}