package `in`.jitinsharma.christmastree

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                ChristmasTree()
            }
        }
    }
}

@Composable
fun ChristmasTree() {
    Box(
        contentAlignment = Alignment.TopCenter,
        modifier = Modifier.fillMaxSize()
    ) {
        Star(
            modifier = Modifier
                .padding(top = 70.dp)
        )
        Triangle(
            modifier = Modifier
                .padding(top = 100.dp)
                .width(100.dp)
                .height(100.dp)
        )
        Triangle(
            modifier = Modifier
                .padding(top = 160.dp)
                .width(200.dp)
                .height(200.dp)
        )
        Column {
            Triangle(
                modifier = Modifier
                    .padding(top = 260.dp)
                    .width(300.dp)
                    .height(300.dp)
            )
            Box(
                modifier = Modifier
                    .width(40.dp)
                    .height(100.dp)
                    .background(
                        color = Color(0xFF964B00),
                        shape = RectangleShape
                    )
                    .align(Alignment.CenterHorizontally)
            )
        }
        Circles()
    }
}

@Preview
@Composable
fun ChristmasTreePreview() {
    ChristmasTree()
}
