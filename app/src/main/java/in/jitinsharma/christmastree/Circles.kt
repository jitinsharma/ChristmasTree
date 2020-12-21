package `in`.jitinsharma.christmastree

import androidx.compose.animation.ColorPropKey
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Circles() {
    val redDefinition = defineTransition(circleColorPropKey, Color.Red, Color(0xFFC40234))
    val redState = colorTransition(definition = redDefinition)
    val blueDefinition = defineTransition(circleColorPropKey, Color.Blue, Color(0xFF333399))
    val blueState = colorTransition(definition = blueDefinition)
    val purpleDefinition = defineTransition(circleColorPropKey, Color.Purple, Color(0xFFA020F0))
    val purpleState = colorTransition(definition = purpleDefinition)
    circleProperties.forEach {
        val animatedColor: Color = when (it.color) {
            Color.Red -> redState[circleColorPropKey]
            Color.Blue -> blueState[circleColorPropKey]
            Color.Purple -> purpleState[circleColorPropKey]
            else -> redState[circleColorPropKey]
        }
        Box(
            modifier = Modifier
                .padding(top = it.topPadding, start = it.startPadding, end = it.endPadding)
                .width(it.size)
                .height(it.size)
                .background(
                    color = animatedColor,
                    shape = CircleShape
                )
        )
    }
}

private data class CircleProperty(
    val color: Color,
    val size: Dp = 20.dp,
    val topPadding: Dp = 0.dp,
    val startPadding: Dp = 0.dp,
    val endPadding: Dp = 0.dp
)

private val circleProperties = listOf(
    CircleProperty(Color.Purple, topPadding = 150.dp),
    CircleProperty(Color.Red, topPadding = 280.dp, startPadding = 60.dp),
    CircleProperty(Color.Blue, topPadding = 280.dp, endPadding = 70.dp),
    CircleProperty(Color.Purple, size = 25.dp, topPadding = 400.dp, endPadding = 10.dp),
    CircleProperty(Color.Red, size = 30.dp, topPadding = 500.dp, startPadding = 140.dp),
    CircleProperty(Color.Blue, size = 30.dp, topPadding = 500.dp, endPadding = 140.dp),
)

private val circleColorPropKey = ColorPropKey(label = "color")

val Color.Companion.Purple get() = Color(0xFF800080)