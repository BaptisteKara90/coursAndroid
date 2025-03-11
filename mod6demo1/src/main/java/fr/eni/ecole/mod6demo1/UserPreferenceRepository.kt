package fr.eni.ecole.mod6demo1

import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserPreferenceRepository(private val context: Context) {

    private val Context.dataStore by preferencesDataStore("user_preference")

    private val KEY_BG_COLOR_SELECTED = intPreferencesKey("KEY_BG_COLOR_SELECTED")

    //Save data
    suspend fun saveBgColor(color: Color) {
        context.dataStore.edit { pref ->
            pref[KEY_BG_COLOR_SELECTED] = color.toArgb()
        }
    }

    //Load a color
    suspend fun getBgColor(): Flow<Color> {
        return context.dataStore.data.map { pref ->
            Color(pref[KEY_BG_COLOR_SELECTED] ?: Color.Blue.toArgb())
        }
    }
}