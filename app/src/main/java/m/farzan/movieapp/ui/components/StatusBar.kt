package m.farzan.movieapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

import m.farzan.movieapp.ui.theme.topBarColor


@Composable
fun StatusBar() {
    Surface(
        modifier = Modifier
            .height(
                WindowInsets.systemBars.asPaddingValues().calculateTopPadding()
            ), color = MaterialTheme.colors.topBarColor
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(), text = ""
        )
    }
}