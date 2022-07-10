package m.farzan.movieapp.ui.movieNavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import m.farzan.movieapp.Model.Movie
import m.farzan.movieapp.Model.movies
import m.farzan.movieapp.ui.details.DetailsScreen
import m.farzan.movieapp.ui.home.HomeScreen

@Composable
fun MovieNavigation() {
    val navController = rememberNavController();
    NavHost(navController = navController, startDestination = MovieScreens.HomeScreen.name) {

        composable(route = MovieScreens.HomeScreen.name) {
            HomeScreen(navController)
        }

        composable(route = MovieScreens.DetailsScreen.name + "/{movie}", arguments = listOf(
            navArgument("movie") {
                type = NavType.IntType
            }
        )) { backStackEntry ->
            val movieIndex = backStackEntry.arguments?.get("movie") as Int
            val movie = movies[movieIndex]
            DetailsScreen(navController = navController, movie)
        }
    }
}