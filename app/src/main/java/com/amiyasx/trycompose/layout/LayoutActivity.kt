package com.amiyasx.trycompose.layout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.amiyasx.trycompose.R
import com.amiyasx.trycompose.ui.theme.TryComposeTheme

class LayoutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TryComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun HorizontalLinear() {
    Row(modifier = Modifier.height(50.dp)) {
        Image(painter = painterResource(R.drawable.earth),
            contentDescription = "")
        Box(modifier = Modifier.fillMaxHeight(), contentAlignment = Alignment.Center) {
            Text(text = "Earth",
                color = MaterialTheme.colors.onSecondary,
                fontFamily = FontFamily.Cursive,
                textAlign = TextAlign.Start
            )
        }
    }
}

@Composable
fun HorizontalLinear2() {
    val expanded = remember {
        mutableStateOf(false)
    }
    Row(modifier = Modifier.height(50.dp)) {
        Image(painter = painterResource(R.drawable.earth),
            contentDescription = "")
        Button(onClick = { expanded.value = !expanded.value },
            modifier = Modifier.padding(all = 8.dp),
            elevation =  ButtonDefaults.elevation(
                defaultElevation = 0.dp,
                pressedElevation = 25.dp,
                disabledElevation = 0.dp
            ),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue)) {
            Box( contentAlignment = Alignment.Center) {
                Text(text = "Earth",
                    color = MaterialTheme.colors.onSecondary,
                    fontFamily = if(expanded.value) FontFamily.Cursive else FontFamily.SansSerif,
                    textAlign = TextAlign.Start
                )
            }
        }
    }
}

@Composable
fun VerticalLinear() {
    Column(modifier = Modifier.padding(all = 10.dp), verticalArrangement = Arrangement.Center,) {
        Card(modifier = Modifier.padding(bottom = 10.dp)) {
            HorizontalLinear()
        }
        Card(modifier = Modifier.padding(bottom = 10.dp)) {
            HorizontalLinear()
        }
        Card(modifier = Modifier.padding(bottom = 10.dp)) {
            HorizontalLinear()
        }

    }
}

@Composable
fun FrameStack() {
    Box(modifier = Modifier.background(Color.Gray), contentAlignment = Alignment.Center) {
        HorizontalLinear()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    TryComposeTheme {
        FrameStack()

    }
}