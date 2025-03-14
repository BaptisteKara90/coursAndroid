package fr.eni.ecole.mod7demo1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {
    private val _weather = MutableStateFlow<Hourlydata?>(null)
    val weather: Flow<Hourlydata?> = _weather

    init{
        fetchWeather()
    }

    fun fetchWeather() {
        viewModelScope.launch(Dispatchers.IO) {
            _weather.value = WeatherApiService.weatherApiService.getWeatherData(
                50.62925,
                3.05725,
                "temperature_2m,wind_speed_10m",
                "temperature_2m"
            ).hourly
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                val application = checkNotNull(extras[APPLICATION_KEY])
                return WeatherViewModel() as T
            }
        }
    }
}