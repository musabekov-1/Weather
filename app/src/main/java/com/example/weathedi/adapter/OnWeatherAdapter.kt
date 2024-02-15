package com.example.weathedi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.weathedi.databinding.ItemWeatherBinding
import com.example.weathedi.remote.Weather

class OnWeatherAdapter(private val weatherList:List<Weather.Forecast.ForecastDay>):Adapter<OnWeatherAdapter.OnWeatherViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnWeatherViewHolder {
        return OnWeatherViewHolder(ItemWeatherBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return weatherList.size
    }

    override fun onBindViewHolder(holder: OnWeatherViewHolder, position: Int) {
        holder.bind(weatherList[position])
    }

    inner class OnWeatherViewHolder(private val binding:ItemWeatherBinding):ViewHolder(binding.root){
        fun bind(day: Weather.Forecast.ForecastDay) {
            binding.tvDay.text = day.date.replace("2024-01-", "January ")
            binding.tvDayTemp.text = day.day.maxTempC.toString().plus("^C")
        }

    }
}