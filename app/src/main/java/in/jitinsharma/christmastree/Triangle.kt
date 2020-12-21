package `in`.jitinsharma.christmastree

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun Triangle(modifier: Modifier) {
    Box(
        modifier = modifier
            .background(
                color = Color.Green,
                shape = triangleShape
            )
    )
}

private val triangleShape = GenericShape { size ->
    val width = size.width
    val height = size.height
    moveTo(0f, height)
    lineTo(width / 2, 0f)
    lineTo(width, height)
    lineTo(0f, height)
}