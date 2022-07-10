package m.farzan.movieapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = Green500,
    primaryVariant = Green700,
    secondary = Green500,
    background = Green1000,
    surface = Green900,
    onPrimary = Green900,
    onSecondary = Green900,
    onBackground = Green50,
    onSurface = Green50,
)

private val LightColorPalette = lightColors(
    primary = Green500,
    primaryVariant = Green700,
    secondary = Green500,
    background = Green50,
    surface = White,
    onPrimary = Green50,
    onSecondary = Green50,
    onBackground = Green1000,
    onSurface = Green1000,
    )


@get:Composable
val Colors.primaryAlpha: Color
    get() = if (isLight) LightColorPalette.primary.copy(alpha = .2f) else DarkColorPalette.primaryVariant.copy(alpha = .2f)

@get:Composable
val Colors.topBarColor: Color
    get() = if (isLight) LightColorPalette.primary else DarkColorPalette.background

@Composable
fun MovieAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }



    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )


}