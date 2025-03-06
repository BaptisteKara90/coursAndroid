package fr.eni.ecole.mod4demo1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import fr.eni.ecole.mod4demo1.ui.theme.CoursAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoursAndroidTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Form(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}


@Composable
fun Form(modifier: Modifier = Modifier) {

    // remember : Save the state until you rotate the device
    var lastname by remember { mutableStateOf("") }

    // rememberSaveable save the state even you rotate the device
    var firstname by rememberSaveable { mutableStateOf("") }
    var age by rememberSaveable { mutableStateOf("") }

    Column(modifier = modifier) {
        TextField(
            label = {
                Text(text = "Prénom ?")
            },
            value = firstname,
            onValueChange = {
                firstname = it
            })

        TextField(
            label = {
                Text(text = "Nom ?")
            },
            value = lastname,
            onValueChange = {
                lastname = it
            })
        TextField(
            label = {
                Text(text = "Age ?")
            },
            value = age,
            onValueChange = {
                age = it
            })
    }
}

