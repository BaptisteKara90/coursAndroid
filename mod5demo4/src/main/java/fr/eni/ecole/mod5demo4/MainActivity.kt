package fr.eni.ecole.mod5demo4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import fr.eni.ecole.mod5demo4.ui.theme.CoursAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoursAndroidTheme {
                Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    NavHostExample()
                }
            }
        }
    }
}

@Composable
fun Homepage(modifier: Modifier = Modifier, LoginValue: String) {
    Text(modifier = modifier.padding(16.dp), text = "Hello $LoginValue")
}

@Composable
fun SignInPage(modifier: Modifier = Modifier, onClickToHome: (String) -> Unit) {

    var LoginValue by rememberSaveable {
        mutableStateOf("")
    }

    Scaffold(modifier = Modifier.padding(16.dp)) { innerPadding ->
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            Text(
                text = "Sign in",
                style = MaterialTheme.typography.headlineMedium
            )
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = LoginValue,
                onValueChange = { LoginValue = it })
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = "......",
                onValueChange = { })
            OutlinedButton(
                modifier = Modifier.padding(innerPadding),
                onClick = { onClickToHome(LoginValue) }
            ) {
                Text("Sign In")
            }
        }
    }
}

@Composable
fun NavHostExample(
    navHostController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navHostController,
        startDestination = SignInDestination.route
    ) {
        composable(SignInDestination.route) {
            SignInPage(onClickToHome = { navHostController.navigate("${HomeDestination.route}/$it") })
        }
        composable(
            route = HomeDestination.routeWithArgs,
            arguments = HomeDestination.args
        ) { navBackStackEntry ->
            val login = navBackStackEntry.arguments?.getString(HomeDestination.argName)
            if (login != null) {
                Homepage(LoginValue = login)
            }
        }
    }
}