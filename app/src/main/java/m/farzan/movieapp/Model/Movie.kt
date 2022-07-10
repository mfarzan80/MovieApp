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
    val cover: String,
    val country: String
) : Serializable


val movies = listOf(
    Movie(
        "Interceptor",
        "One Army captain is forced use her years of tactical " +
                "training and military expertise when a simultaneous coordinated attack threatens" +
                " the remote missile interceptor station of which she is in command",
        listOf("Adventure", "Action"), 4.5, 2022,
        "https://upload.wikimedia.org/wikipedia/en/3/31/Interceptor_%28film%29.jpg", "United States"
    ),
    Movie(
        "The Man From Toronto",
        "The plot follows a New York City screw-up named " +
                "Teddy who is mistaken for the \"Man from Toronto\" when the two wind up in " +
                "the same Airbnb. Antics ensue.",
        listOf("Adventure", "Action"), 5.7, 2022,
        "https://upload.wikimedia.org/wikipedia/en/7/75/The_Man_from_Toronto_%282022_film%29.jpg", "United States"
    ),
    Movie(
        "Red Notice",
        "In the world of international crime, an " +
                "Interpol agent attempts to hunt down and capture the world's most wanted art thief",
        listOf("Action", "Comedy"), 6.3, 2021,
        "https://upload.wikimedia.org/wikipedia/en/0/0c/Red_Notice_-_film_promotional_image.jpg", "United States"
    ),
    Movie(
        "The Adam Project",
        "After accidentally crash-landing in 2022, time-traveling " +
                "fighter pilot Adam Reed teams up with his 12-year-old self for a mission to save the future",
        listOf("Action", "Comedy"), 6.7, 2021,
        "https://upload.wikimedia.org/wikipedia/en/d/d7/The_Adam_Project_poster.png", "United States"
    )
)