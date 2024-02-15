package com.example.weathedi.di

import com.example.weathedi.remote.WeatherApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(SingletonComponent::class)
@Module
class AppModule {
    @Provides
    fun provideApi():WeatherApi{
        return Retrofit.Builder().baseUrl("https://weatherapi-com.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build().create(WeatherApi::class.java)
    }
}