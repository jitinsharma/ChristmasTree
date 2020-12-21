package `in`.jitinsharma.christmastree

import androidx.compose.animation.ColorPropKey
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Star(modifier: Modifier) {
    val starColorDefinition = defineTransition(starColorPropKey, Color.Yellow, Color(0xFFFFD700))
    val startColorState = colorTransition(definition = starColorDefinition)
    Box(
        modifier = modifier
            .width(40.dp)
            .height(40.dp)
            .background(
                color = startColorState[starColorPropKey],
                shape = starShape
            )
    )
}

private val starShape = GenericShape { size ->
    val w = size.width
    val h = size.height
    moveTo(0f, 0.4f * h)

    lineTo(0.33f * w, 0.33f * h)
    lineTo(0.5f * w, 0f)

    lineTo(0.67f * w, 0.33f * h)
    lineTo(w, 0.4f * h)

    lineTo(0.75f * w, 0.6f * h)
    lineTo(0.85f * w, h)

    lineTo(0.5f * w, 0.75f * h)
    lineTo(0.15f * w, h)

    lineTo(0.25f * w, 0.6f * h)
    lineTo(0f, 0.4f * h)
}

private val starColorPropKey = ColorPropKey(label = "color")
