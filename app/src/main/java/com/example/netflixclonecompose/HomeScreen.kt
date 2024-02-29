package com.example.netflixclonecompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(navController: NavHostController) {
    val navigateToSecondScreen: () -> Unit = {
        navController.navigate("movie")
    }

    Column {
        // Header Section
        TopAppSection()
        NetflixContentChooser()
        featuredMovieSection()
        Column {
            AddMovieList(movieType = "Action", navigateToSecondScreen)
            AddMovieList(movieType = "Drama", navigateToSecondScreen)
            AddMovieList(movieType = "Adventure", navigateToSecondScreen)
            AddMovieList(movieType = "New releases", navigateToSecondScreen)
            AddMovieList(movieType = "Shooting", navigateToSecondScreen)
            AddMovieList(movieType = "watch it again", navigateToSecondScreen)
        }
    }

}

