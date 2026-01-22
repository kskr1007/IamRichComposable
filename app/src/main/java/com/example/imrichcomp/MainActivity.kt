package com.example.imrichcomp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.imrichcomp.ui.theme.ImRichCompTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ImRichCompTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            IamRich()        }
    }
}
@Composable
fun IamRich(modifier:Modifier=Modifier) {
    var isVisible by remember { mutableStateOf(false) }
    val context= LocalContext.current
    Column(
        //modifier = Modifier.fillMaxSize(),
        modifier=modifier,
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = if (isVisible) "I am Poor" else "I am Rich",
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = modifier
        )

        if (isVisible) {
            Image(
                painter = painterResource(id = R.drawable.diamond_image),
                contentDescription = "diamond image",
                modifier = Modifier.size(200.dp)
            )
        }
        if(isVisible) {
            Button(onClick = { isVisible = false }) {
                // only shows button when it hasn't been clicked
                Text(text = "Click Me")
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ImRichCompTheme {
        MyApp()
    }
}