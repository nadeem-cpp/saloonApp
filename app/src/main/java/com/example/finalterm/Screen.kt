package com.example.finalterm

sealed class Screen(val route: String)
{
    object SplashScreen: Screen("splash_screen")
    object LoginScreen: Screen("login_screen")
    object SignUpScreen: Screen("signup_screen")
    object HomeScreen: Screen("home_screen")
    object SettingScreen: Screen("setting_screen")
    object ProfileScreen: Screen("profile_screen")
}
