package fr.eni.ecole.mod4tp1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import fr.eni.ecole.mod4tp1.ui.theme.CoursAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoursAndroidTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   Column(modifier = Modifier.padding(innerPadding)) {
                       DiceGameScreen()
                   }
                }
            }
        }
    }
}

@Composable
fun DiceGameScreen(
    modifier : Modifier = Modifier,
    viewModel: DiceGame = viewModel()
){

    val counterLeft by viewModel.counterLeft.collectAsState();
    val counterRight by viewModel.counterRight.collectAsState();
    val dice by viewModel.dice.collectAsState();


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

    ){
        Image(painter = painterResource(id = dice), contentDescription = "dice", modifier = Modifier.size(75.dp))
        Text(text = viewModel.nbThrowsAll.toString())
        Row(modifier= Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround) {
            Text(text = "Total =  ${counterLeft}  /  ${viewModel.nbThrowsLeft}  Lancé(s)")
            Text(text = "Total = ${counterRight} / ${viewModel.nbThrowsRight} Lancé(s)")
        }
        Row(
            modifier= Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
            ) {
            Button(
                onClick = { viewModel.rollDiceLeft() },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue,
                    contentColor = Color.White
                )
            ) {
                Text(text = "Gauche")
            }

            Button(
                onClick = { viewModel.rollDiceRight() },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Blue
                ),
                border = ButtonDefaults.outlinedButtonBorder
            ) {
                Text(text = "Droite")
            }
        }
        Button(onClick = { viewModel.reset() }) {
            Text(text = "Recommencer")
        }
    }

}


@Preview
@Composable
fun Preview(){
    DiceGameScreen()
}