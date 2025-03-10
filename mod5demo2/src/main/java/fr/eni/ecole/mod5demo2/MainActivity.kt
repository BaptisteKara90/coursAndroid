package fr.eni.ecole.mod5demo2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.eni.ecole.mod5demo2.ui.theme.CoursAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoursAndroidTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    Column(modifier = Modifier.padding(100.dp)) {
                        GoTo(
                            modifier = Modifier.padding(it),
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Call(
                            modifier = Modifier.padding(it),
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun GoTo(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Button(onClick = {
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse("geo:48.039, -1.692")
            ).also { context.startActivity(it) }
        }) {
            Text("Go to Google Maps")
        }
    }

}

@Composable
fun Call(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val requestPermission =
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.RequestPermission()
        ) { isGranted ->
            if (isGranted) {
                Intent(Intent.ACTION_CALL, Uri.parse("tel:0636656565"))
                    .also {
                        context.startActivity(it)
                    }

            } else {
                Intent(Intent.ACTION_CALL, Uri.parse("tel:066666666666"))
                    .also {
                        context.startActivity(it)
                    }
            }
        }
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = {
            requestPermission.launch(android.Manifest.permission.CALL_PHONE)
        }) {
            Text(text = "NightCall")
        }
    }
}

