package com.example.finalterm

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation() {
    var navController = rememberNavController()

    NavHost(navController = navController, startDestination =Screen.SplashScreen.route )
    {
        composable(Screen.SplashScreen.route)
        {
            AppSplashScreen(navController = navController)
        }
        composable(
//            Screen.LoginScreen.route + "/{name}",
//            Screen.LoginScreen.route + "/{name}/{age}",
            Screen.LoginScreen.route + "?name={name}", //optional value, will get default value
            arguments = listOf(
                navArgument("name")
                {
                    type = NavType.StringType
                    defaultValue = "nadeem"
                    nullable = true
                }
            )
        )
        {
            LoginScreen(name = it.arguments?.getString("name"), navController)
        }

        // signup route
        composable(
            Screen.SignUpScreen.route
        )
        {
            SignUpScreen(navController = navController)
        }

        composable(Screen.HomeScreen.route)
        {
            HomeScreen()
        }

        composable(Screen.SettingScreen.route)
        {
            SettingScreen()
        }
        composable(Screen.ProfileScreen.route)
        {
            ProfileScreen()
        }
    }

}