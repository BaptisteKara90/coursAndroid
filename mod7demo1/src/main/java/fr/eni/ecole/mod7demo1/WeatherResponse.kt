package fr.eni.ecole.mod7demo1

import com.squareup.moshi.Json

data class WeatherResponse(
    val hourly: Hourlydata
)

data class Hourlydata(
    val time: List<String>,
    @Json(name = "temperature_2m")
    val temperature: List<Double>
)