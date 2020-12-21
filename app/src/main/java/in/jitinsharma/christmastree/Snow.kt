package `in`.jitinsharma.christmastree

import androidx.compose.animation.animatedFloat
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.onActive
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp

@Composable
fun Snow(modifier: Modifier) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        repeat(30) {
            val topPadding = mutableStateOf(10.dp)
            val animatedFloat = animatedFloat(initVal = 0f)
            val randomDuration = (2000..4000).random()
            onActive {
                animatedFloat.animateTo(
                    targetValue = 100f,
                    anim = infiniteRepeatable(
                        animation = tween(durationMillis = randomDuration, easing = LinearEasing)
                    ),
                    onEnd = { _, _ ->
                        topPadding.value = 10.dp
                    }
                )
            }
            Image(
                imageVector = vectorResource(id = R.drawable.ic_snowflake),
                modifier = modifier
                    .padding(
                        top = topPadding.value.times(animatedFloat.value)
                    )
                    .width(8.dp)
                    .height(8.dp)
            )
        }
    }
}
