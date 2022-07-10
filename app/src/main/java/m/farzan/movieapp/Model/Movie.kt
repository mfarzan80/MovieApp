package m.farzan.movieapp.Model

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.AnnotatedString
import androidx.navigation.NavType
import m.farzan.movieapp.R
import java.io.Serializable

data class Movie(
    val name: String,
    val description: String,
    val genre: List<String>,
    val imdbRate: Double,
    val year: Int,
    val coverId: Int,
    val country: String
) : Serializable


val movies = listOf(
    Movie(
        "Interceptor",
        "One Army captain is forced use her years of tactical " +
                "training and military expertise when a simultaneous coordinated attack threatens" +
                " the remote missile interceptor station of which she is in command",
        listOf("Adventure", "Action"), 4.5, 2022,
        R.drawable.interceptorcover, "United States"
    ),
    Movie(
        "The Man From Toronto",
        "The plot follows a New York City screw-up named " +
                "Teddy who is mistaken for the \"Man from Toronto\" when the two wind up in " +
                "the same Airbnb. Antics ensue.",
        listOf("Adventure", "Action"), 5.7, 2022,
        R.drawable.the_man_from_torento, "United States"
    ),
    Movie(
        "Red Notice",
        "In the world of international crime, an " +
                "Interpol agent attempts to hunt down and capture the world's most wanted art thief",
        listOf("Action", "Comedy"), 6.3, 2021,
        R.drawable.rednotice, "United States"
    ),
    Movie(
        "The Adam Project",
        "After accidentally crash-landing in 2022, time-traveling " +
                "fighter pilot Adam Reed teams up with his 12-year-old self for a mission to save the future",
        listOf("Action", "Comedy"), 6.7, 2021,
        R.drawable.adam_project, "United States"
    )
)