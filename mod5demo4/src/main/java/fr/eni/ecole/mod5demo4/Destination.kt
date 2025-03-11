package fr.eni.ecole.mod5demo4

import androidx.navigation.NavType
import androidx.navigation.navArgument

interface Destination {
    val route : String
}

object HomeDestination : Destination {
    override val route: String = "Home"

    //Argument public
    val argName by lazy{"LoginValue"}

    var args = listOf(navArgument(argName){
        type = NavType.StringType
    })

    val routeWithArgs = "$route/{$argName}"
}

object SignInDestination : Destination {
    override val route: String = "SignIn"

}