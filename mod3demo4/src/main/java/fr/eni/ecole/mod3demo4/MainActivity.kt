package fr.eni.ecole.mod3demo4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

        }
    }
}


@Composable
fun SpacerExample(){
    Column{
        Text(text = "La communauté de l'anneau")
        Spacer(modifier = Modifier.height(8.dp))
        Row (modifier = Modifier.height(IntrinsicSize.Min)) {
            Spacer(modifier = Modifier.width(1.dp))
            Spacer(
                modifier = Modifier
                    .width(2.dp)
                    .background(Color.Red)
                    .fillMaxHeight()
            )
            Text(text = "Les deux tours")
            Spacer(modifier = Modifier.width(1.dp))
            Spacer(
                modifier = Modifier
                    .width(2.dp)
                    .background(Color.Red)
                    .fillMaxHeight()
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Le retour du roi")
    }
}


@Composable
@Preview
fun Preview() {
    SpacerExample()
}