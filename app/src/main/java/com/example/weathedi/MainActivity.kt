package com.example.weathedi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.weathedi.adapter.OnWeatherAdapter
import com.example.weathedi.databinding.ActivityMainBinding
import com.example.weathedi.mvvm.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private val viewModel:WeatherViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSearch.setOnClickListener {
            viewModel.getLiveWeather(city = binding.etCity.editText?.text.toString()).observe(this){
                binding.tvCity.text = it.location.name
                binding.tvCityTemp.text = it.current.tempC.toString().plus("^C")
                val adapter = OnWeatherAdapter(it.forecast.forecastDay)
                binding.recyclerView.adapter = adapter
            }
        }
    }
}