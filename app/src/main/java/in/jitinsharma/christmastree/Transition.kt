package `in`.jitinsharma.christmastree

import androidx.compose.animation.ColorPropKey
import androidx.compose.animation.core.TransitionDefinition
import androidx.compose.animation.core.TransitionState
import androidx.compose.animation.core.transitionDefinition
import androidx.compose.animation.core.tween
import androidx.compose.animation.transition
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color

fun defineTransition(
    colorPropKey: ColorPropKey,
    startColor: Color,
    endColor: Color
): TransitionDefinition<Int> {
    return transitionDefinition {
        state(0) {
            this[colorPropKey] = startColor
        }

        state(1) {
            this[colorPropKey] = endColor
        }

        transition(0 to 1, 1 to 0) {
            colorPropKey using tween(
                durationMillis = 200
            )
        }
    }
}

@Composable
fun colorTransition(definition: TransitionDefinition<Int>): TransitionState {
    var initialState by remember { mutableStateOf(0) }
    var toState by remember { mutableStateOf(1) }
    return transition(
        definition = definition,
        initState = initialState,
        toState = toState,
        onStateChangeFinished =
        { state ->
            when (state) {
                0 -> {
                    initialState = 0
                    toState = 1
                }
                1 -> {
                    initialState = 1
                    toState = 0
                }
            }
        }
    )
}