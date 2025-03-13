package fr.eni.ecole.mod6demo3.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import fr.eni.ecole.mod6demo3.bo.Music
import fr.eni.ecole.mod6demo3.dao.MusicDao
import fr.eni.ecole.mod6demo3.room.AppDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MusicViewModel(private val musicDao: MusicDao) : ViewModel() {

    private val _musics = MutableStateFlow<List<Music>>(emptyList())
    val musics: Flow<List<Music>> = _musics



    init{
        viewModelScope.launch{
            insertMusic(
                Music(
                0L,
                "Dean Town",
                "Vulfpeck",
                250
                )
            )

            insertMusic(
                Music(
                    0L,
                    "Suffocate",
                    "Poppy",
                    300
                )
            )
            loadMusics()
        }
    }


    private suspend fun loadMusics() {
        withContext(Dispatchers.IO) {
            _musics.value = musicDao.findAll()
        }
    }

    private suspend fun insertMusic(music: Music) {
        withContext(Dispatchers.IO) {
            musicDao.insert(music)
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
                return MusicViewModel(
                    AppDataBase.getInstance(application.applicationContext).musicDao()
                ) as T
            }
        }
    }

}