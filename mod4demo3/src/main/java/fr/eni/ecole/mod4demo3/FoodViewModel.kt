package fr.eni.ecole.mod4demo3

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class FoodViewModel(private val foodRepository: FoodRepository) : ViewModel() {

    private val _foods = MutableStateFlow<List<String>>(emptyList())
    var foods: StateFlow<List<String>> = _foods


    init {
        _foods.value = foodRepository.getFoods()
    }

    companion object {

        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
//                val application = checkNotNull(extras[APPLICATION_KEY])
//                val savedStateHandle = extras.createSavedStateHandle()

                return FoodViewModel(
                    FoodRepository()
                ) as T
            }
        }
    }
}