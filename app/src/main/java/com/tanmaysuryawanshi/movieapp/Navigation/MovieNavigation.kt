package com.tanmaysuryawanshi.movieapp.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.tanmaysuryawanshi.movieapp.Screens.allmovie.ContentAllMovie
import com.tanmaysuryawanshi.movieapp.Screens.allmovie.allmovie
import com.tanmaysuryawanshi.movieapp.Screens.detail.DetailScreen
import com.tanmaysuryawanshi.movieapp.Screens.home.HomeScreen

@Composable
fun MovieNavigation() {
    val navController= rememberNavController( )
    NavHost(navController = navController,
        startDestination = MovieScreen.AllMovieScreen.name){

        composable(MovieScreen.HomeScreen.name){
            HomeScreen(navController)
        }
        composable(MovieScreen.AllMovieScreen.name){
           allmovie(navController = navController)
        }

        composable(MovieScreen.DetailScreen.name+"/{movie}",
        arguments = listOf(navArgument(name = "movie"){
            type= NavType.StringType
        })
        ){
            backStackEntry->
            DetailScreen(navController,backStackEntry.arguments?.getString("movie"))
        }

    }
}