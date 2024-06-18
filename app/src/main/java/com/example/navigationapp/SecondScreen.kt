package com.example.navigationapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SecondScreen(name: String, age: String, navigateToFirstScreen: () -> Unit,navigateToThirdScreen: () -> Unit) {
    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "This is the Second Screen")
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Welcome $name who is $age years old")
        Button(onClick = {
            navigateToFirstScreen()
        }) {
            Text(text = "Go to First Screen")
        }
        Button(onClick = {
            navigateToThirdScreen()
        }) {
            Text(text = "Go to Third Screen")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SecondPreview() {
    SecondScreen(name = "berto", age = "25", {}, {})
}
