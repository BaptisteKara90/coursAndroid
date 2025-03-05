package fr.eni.ecole.mod3demo3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import fr.eni.ecole.mod3demo3.ui.theme.CoursAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {


        }
    }
}

@Composable
fun RowAndColumnExample() {

    Column{
        Text("Row and Column example")
        Row{
            Text("Row 1, ")
            Text("Row 2, ")
            Text("Row 3, ")
        }
        Column{
            Text("Column 1")
            Text("Column 2")
            Text("Column 3")
        }
    }
}

@Composable
fun BoxExample() {
    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = Modifier.clip(CircleShape)
    ){
        Image(
            painter = painterResource(id = R.drawable.goatkiss),
            contentDescription = "A goat kiss",
        )
        Icon(
            imageVector = Icons.Default.Favorite,
            contentDescription = "little heart",
            tint = Color.Red
        )
    }
}

@Preview
@Composable
fun Preview() {
    BoxExample()
}
