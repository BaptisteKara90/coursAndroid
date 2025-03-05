package fr.eni.ecole.mod3demo5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArticleList()
        }
    }
}

@Composable
fun ArticleList(modifier : Modifier = Modifier){

    val articles = List(300){
        "Article $it"
    }

    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(articles){
            ArticleItem(article = it)
        }
    }

}


@Composable
fun ArticleItem(article: String, modifier: Modifier = Modifier) {

    Surface (
        border = BorderStroke(2.dp, Color.Green),
        shape = CircleShape,
        shadowElevation = 4.dp,
        color = Color.Black,
        contentColor = Color.White
    ){

        var isChecked = false

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
        ) {
            Text(text = article, style = TextStyle(fontSize = 16.sp))
            Checkbox(checked = isChecked, onCheckedChange = {
                isChecked = it
            })
        }
    }
}


@Composable
@Preview
fun Preview() {
    ArticleItem(article = "Bol de café")
    ArticleList()
}