package m.farzan.movieapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.valentinilk.shimmer.ShimmerBounds
import com.valentinilk.shimmer.rememberShimmer
import com.valentinilk.shimmer.shimmer
import com.valentinilk.shimmer.unclippedBoundsInWindow

@Composable
fun ShimmerImage(
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Crop,
    painter: Painter,
    contentDescription: String,
    shape: Shape = RoundedCornerShape(0.dp),
    elevation: Dp = 0.dp

) {

    Card(modifier = modifier, shape = shape, elevation = elevation) {
        Text(
            modifier = Modifier.shimmer()
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = Color.Gray), text = ""
        )
        Image(
            modifier = Modifier
                .fillMaxWidth().zIndex(2f)
                .fillMaxHeight(),
            painter = painter,
            contentDescription = contentDescription,
            contentScale = contentScale
        )
    }

}