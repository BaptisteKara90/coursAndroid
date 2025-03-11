package fr.eni.ecole.mod6demo1

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SettingsViewModel(private val userPreferenceRepository: UserPreferenceRepository) :
    ViewModel() {


    private val _colors = MutableStateFlow<List<Color>>(
        listOf(Color.Red, Color.Green, Color.Blue, Color.Yellow, Color.White)
    )

    val colors: StateFlow<List<Color>> = _colors

    private val _usercolor = MutableStateFlow<Color>(Color.White)
    val usercolor: StateFlow<Color> = _usercolor

    init {
        getBgColor()
    }

    fun getBgColor() {
        viewModelScope.launch {
            userPreferenceRepository.getBgColor().collect {
                _usercolor.value = it
            }
        }
    }

    fun setBgColor(color: Color) {
        viewModelScope.launch {
            userPreferenceRepository.saveBgColor(color)
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
                return SettingsViewModel(UserPreferenceRepository(application.applicationContext)) as T
            }
        }
    }
}