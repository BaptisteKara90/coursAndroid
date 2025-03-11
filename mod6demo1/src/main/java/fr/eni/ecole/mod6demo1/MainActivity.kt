package fr.eni.ecole.mod6demo1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import fr.eni.ecole.mod6demo1.ui.theme.CoursAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoursAndroidTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SettingsScreen(
                        modifier = Modifier.padding(innerPadding)
                    )

                }
            }
        }
    }
}


@Composable
fun SettingsScreen(modifier : Modifier = Modifier,settingsViewModel: SettingsViewModel = viewModel(factory = SettingsViewModel.Factory)) {

    val colors by settingsViewModel.colors.collectAsState()
    val userColor by settingsViewModel.usercolor.collectAsState()

    Scaffold(containerColor = userColor) {
        Column(modifier = Modifier.padding(it)) {
            colors.forEach { color ->
                Spacer(modifier = Modifier
                    .background(color)
                    .height(50.dp)
                    .fillMaxWidth()
                    .border(1.dp, Color.Black)
                    .clickable {
                        settingsViewModel.setBgColor(color)
                    }
                )
            }
        }
    }
}