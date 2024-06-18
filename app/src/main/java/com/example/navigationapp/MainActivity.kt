package com.example.navigationapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigationapp.ui.theme.NavigationAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationAppTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "firstscreen") {
        composable("firstscreen") {
            FirstScreen(
                navigateToSecondScreen = { name, age ->
                    navController.navigate("secondscreen/$name/$age")
                },
            )
        }
        composable("secondscreen/{name}/{age}") {
            val name = it.arguments?.getString("name") ?: "no name"
            val age = it.arguments?.getString("age") ?: "no age"
            SecondScreen(
                name = name,
                age = age,
                navigateToFirstScreen = {
                    navController.navigate("firstscreen")
                },
                navigateToThirdScreen = {
                    navController.navigate("thirdscreen")
                },
            )
        }
        composable("thirdscreen") {
            ThirdScreen(
                navigateToSecondScreen = {
                    navController.navigate("secondscreen/{name}/{age}")
                },
            )
        }
    }
}
