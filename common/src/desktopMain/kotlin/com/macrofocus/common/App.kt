package com.macrofocus.common
import androidx.compose.material.Text
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import java.lang.Runtime

@Composable
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }

    MaterialTheme {
        Button(onClick = {
            text = "Hello, ${getPlatformName()} with ${Runtime.getRuntime().availableProcessors()} processors"
        }) {
            Text(text)
        }
    }
}
