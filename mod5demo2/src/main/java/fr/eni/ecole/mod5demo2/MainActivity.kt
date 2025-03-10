package fr.eni.ecole.mod5demo2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import fr.eni.ecole.mod5demo2.ui.theme.CoursAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoursAndroidTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    GoTo(
                        modifier = Modifier.padding(it),
                    )
                }
            }
        }
    }
}

@Composable
fun GoTo(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Button(onClick = {
        Intent (Intent.ACTION_VIEW, Uri.parse("geo:48.039, -1.692")).also{context.startActivity(it)}
    }) {
        Text("Go to Google Maps")
    }
}

