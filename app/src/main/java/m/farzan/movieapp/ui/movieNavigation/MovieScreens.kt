package m.farzan.movieapp.ui.movieNavigation

import java.lang.IllegalArgumentException

enum class MovieScreens {
    HomeScreen, DetailsScreen;

    companion object {
        fun route(route: String?) : MovieScreens {
            return when(route){
                HomeScreen.name -> HomeScreen
                DetailsScreen.name -> DetailsScreen
                null -> HomeScreen
                else -> throw IllegalArgumentException("Invalid route")
            }
        }
    }
}