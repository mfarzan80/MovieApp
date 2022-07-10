package m.farzan.movieapp.ui.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import m.farzan.movieapp.MainActivity
import m.farzan.movieapp.Model.Movie
import m.farzan.movieapp.Model.movies

import m.farzan.movieapp.R
import m.farzan.movieapp.ui.components.ShapeImage
import m.farzan.movieapp.ui.components.StatusBar
import m.farzan.movieapp.ui.movieNavigation.MovieScreens
import m.farzan.movieapp.ui.theme.primaryAlpha
import m.farzan.movieapp.ui.theme.topBarColor


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {

    val systemUiController = rememberSystemUiController()
    //systemUiController.setSystemBarsColor(color = MaterialTheme.colors.topBarColor)

    Surface() {
        Column {
            StatusBar()
            Scaffold(topBar = {
                TopAppBar(elevation = 0.dp, backgroundColor = MaterialTheme.colors.topBarColor) {
                    Text(
                        "Movies",
                        modifier = Modifier.padding(10.dp, 0.dp),
                        style = MaterialTheme.typography.h5,
                        color = Color.White
                    )
                }
            }) {

                MainContent(movies, navController)
            }
        }
    }
}


@Composable
fun MainContent(movieList: List<Movie>, navController: NavController) {

    LazyColumn {
        items(items = movieList) {
            Spacer(modifier = Modifier.height(25.dp))
            MovieCard(movie = it) {
                navController.navigate(
                    route = MovieScreens.DetailsScreen.name + "/${
                        movieList.indexOf(
                            it
                        )
                    }"
                )
            }
        }
    }

}


@OptIn(ExperimentalMaterialApi::class)
@Preview(showBackground = true)
@Composable
fun MovieCard(movie: Movie = movies[0], onCardClick: () -> Unit = {}) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.coerceAtMost(configuration.screenHeightDp).dp

    Card(
        modifier = Modifier
            .padding(top = 5.dp, bottom = 10.dp)
            .padding(horizontal = 10.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = 6.dp, backgroundColor = MaterialTheme.colors.surface, onClick = onCardClick

    ) {
        ConstraintLayout {
            val cover = createRef()
            val tittle = createRef()
            val imdb = createRef()

            ShapeImage(
                modifier = Modifier
                    .constrainAs(cover) {
                        start.linkTo(parent.start)
                        end.linkTo(tittle.start)
                        top.linkTo(parent.top)
                        bottom.linkTo(tittle.bottom)
                        height = Dimension.fillToConstraints
                    }
                    .width(screenWidth * 33 / 100),
                contentScale = ContentScale.Crop,
                shape = RoundedCornerShape(corner = CornerSize(16.dp)),
                painter = painterResource(id = movie.coverId),
                contentDescription = "${movie.name} cover"
            )



            Column(modifier = Modifier.constrainAs(tittle) {
                top.linkTo(parent.top, 10.dp)
                start.linkTo(cover.end, 15.dp)
                end.linkTo(parent.end, 10.dp)
                width = Dimension.fillToConstraints
            }) {
                Text(
                    text = movie.name, style = MaterialTheme.typography.h5
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = movie.description, style = MaterialTheme.typography.subtitle2,
                    textAlign = TextAlign.Justify,
                    maxLines = 3
                )

                Spacer(modifier = Modifier.height(15.dp))

                GenreRow(genres = movie.genre)

                Spacer(modifier = Modifier.height(15.dp))



                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        modifier = Modifier.size(20.dp),
                        imageVector = Icons.Default.CalendarToday,
                        contentDescription = "year",
                        tint = MaterialTheme.colors.primary.copy(alpha = .8f)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = movie.year.toString(), style = MaterialTheme.typography.caption)
                }

                Spacer(modifier = Modifier.height(10.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        modifier = Modifier.size(20.dp),
                        imageVector = Icons.Outlined.LocationOn,
                        contentDescription = "Country",
                        tint = MaterialTheme.colors.primary.copy(alpha = .8f)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = movie.country, style = MaterialTheme.typography.caption)
                }

                Spacer(modifier = Modifier.height(10.dp))

            }

            ImdbRow(
                modifier = Modifier
                    .constrainAs(imdb) {
                        bottom.linkTo(tittle.bottom, 10.dp)
                        end.linkTo(parent.end, 10.dp)
                    },
            ) {
                Text(
                    text = "${movie.imdbRate}",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Black
                )
            }


        }
    }
}

@Composable
fun GenreRow(genres: List<String>, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        for (genre in genres) {
            Surface(
                color = MaterialTheme.colors.primaryAlpha,
                shape = RoundedCornerShape(5.dp)
            ) {

                Text(
                    modifier = Modifier.padding(5.dp, 3.dp),
                    text = genre,
                    style = MaterialTheme.typography.button,
                )
            }
            Spacer(modifier = Modifier.width(7.dp))

        }
    }
}

@Composable
fun ImdbRow(modifier: Modifier, imdb: @Composable () -> Unit) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {


        ShapeImage(
            modifier = Modifier.size(35.dp, 25.dp),
            painter = painterResource(id = R.drawable.imdbpng),
            contentDescription = "imdb",
            shape = RoundedCornerShape(5.dp)
        )
        Spacer(modifier = Modifier.width(5.dp))
        imdb()


    }
}



