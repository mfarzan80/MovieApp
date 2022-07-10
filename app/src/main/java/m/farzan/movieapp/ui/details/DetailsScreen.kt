package m.farzan.movieapp.ui.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import m.farzan.movieapp.Model.Movie
import m.farzan.movieapp.Model.movies
import m.farzan.movieapp.ui.home.GenreRow
import m.farzan.movieapp.ui.home.ImdbRow
import m.farzan.movieapp.ui.theme.*

@Composable
fun DetailsScreen(navController: NavController, movie: Movie) {
    val systemUiController = rememberSystemUiController()

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .verticalScroll(rememberScrollState())
    ) {
        DetailsContact(movie){
            navController.popBackStack()
        }
    }

}

@OptIn(ExperimentalMaterialApi::class)
@Preview(showBackground = true)
@Composable
fun DetailsContact(movie: Movie = movies[0] , onBackClick : () -> Unit = {}) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val statusBarHeight = WindowInsets.systemBars.asPaddingValues().calculateTopPadding()

    ConstraintLayout {
        val poster = createRef()
        val grad = createRef()
        val imdb = createRef()
        val tittle = createRef()
        val details = createRef()
        val backBtn = createRef()

        Image(
            painter = painterResource(id = movie.coverId),
            contentDescription = "cover",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(poster) {
                    top.linkTo(parent.top)
                }
                .height(screenHeight * 60 / 100)
        )

        Row(modifier = Modifier
            .constrainAs(grad) {
                top.linkTo(poster.top)
                bottom.linkTo(poster.bottom)
                start.linkTo(poster.start)
                end.linkTo(poster.end)
                height = Dimension.fillToConstraints
                width = Dimension.fillToConstraints
            }
            .zIndex(1f)
            .background(
                brush = Brush.verticalGradient(
                    0.0f to Green1000.copy(alpha = .0f),
                    0.6f to Green1000.copy(alpha = .5f),
                    1.0f to Green1000.copy(alpha = 1f),
                )
            )) {}

        Surface(
            modifier = Modifier
                .size(40.dp)
                .zIndex(2f)
                .constrainAs(backBtn) {
                    top.linkTo(parent.top, statusBarHeight + 10.dp)
                    start.linkTo(parent.start, 10.dp)
                },
            color = Color.Black.copy(.5f),
            shape = CircleShape ,
            onClick = onBackClick
        ) {
            Icon(
                modifier = Modifier.padding(7.dp),
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "back",
                tint = White
            )
        }


        Column(
            modifier = Modifier
                .constrainAs(tittle) {
                    bottom.linkTo(poster.bottom, 5.dp)
                    start.linkTo(parent.start, 10.dp)
                    end.linkTo(imdb.start, 10.dp)
                    width = Dimension.fillToConstraints
                }
                .zIndex(2f)
        ) {
            Text(
                text = movie.name,
                style = MaterialTheme.typography.h4,
                color = White,
                textAlign = TextAlign.Start
            )
            //Spacer(modifier = Modifier.height(10.dp))
        }


        ImdbRow(modifier = Modifier
            .constrainAs(imdb) {
                top.linkTo(tittle.top, 5.dp)
                bottom.linkTo(tittle.bottom)
                end.linkTo(poster.end, 15.dp)
            }
            .zIndex(2f)) {
            Text(
                text = "${movie.imdbRate}",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                color = White
            )
        }



        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .constrainAs(details) {
                top.linkTo(poster.bottom)
            }
            .padding(horizontal = 15.dp)
        ) {
            Spacer(modifier = Modifier.height(5.dp))
            GenreRow(genres = movie.genre)

            Spacer(modifier = Modifier.height(15.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    modifier = Modifier.size(30.dp),
                    imageVector = Icons.Default.CalendarToday,
                    contentDescription = "year",
                    tint = MaterialTheme.colors.primary.copy(alpha = .8f)
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = "Year      ", style = MaterialTheme.typography.subtitle1)
                Spacer(modifier = Modifier.width(25.dp))
                Text(text = movie.year.toString(), style = MaterialTheme.typography.body1)
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    modifier = Modifier.size(30.dp),
                    imageVector = Icons.Outlined.LocationOn,
                    contentDescription = "Country",
                    tint = MaterialTheme.colors.primary.copy(alpha = .8f)
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = "Country", style = MaterialTheme.typography.subtitle1)
                Spacer(modifier = Modifier.width(25.dp))
                Text(text = movie.country, style = MaterialTheme.typography.body1)
            }

            Spacer(modifier = Modifier.height(12.dp))

            Column {
                Text(text = "Movie Story:", style = MaterialTheme.typography.h6)
                Text(
                    modifier = Modifier.padding(horizontal = 5.dp, vertical = 3.dp),
                    text = movie.description,
                    style = MaterialTheme.typography.body1,
                    textAlign = TextAlign.Justify
                )
            }

        }


    }


}
