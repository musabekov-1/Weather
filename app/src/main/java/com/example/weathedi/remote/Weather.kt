package com.example.weathedi.remote

import com.google.gson.annotations.SerializedName

data class Weather(
    val current: Current,
    val forecast: Forecast,
    val location: Location
) {
    data class Current(
        val condition: Condition,
        @SerializedName("temp_c")
        val tempC: Double,
    ) {
        data class Condition(
            val text: String
        )
    }

    data class Forecast(
        @SerializedName("forecastday")
        val forecastDay: List<ForecastDay>
    ) {
        data class ForecastDay(
            val date: String,
            val day: Day,
        ) {
            data class Day(
                val condition: Condition,
                @SerializedName("maxtemp_c")
                val maxTempC: Double,
            ) {
                data class Condition(
                    val text: String
                )
            }
        }
    }

    data class Location(
        val name: String,
    )
}
