package com.tanmaysuryawanshi.movieapp.Navigation

enum class MovieScreen {
    HomeScreen,
    DetailScreen,
    AllMovieScreen;
    companion object{

        fun fromRoute(route:String?):MovieScreen
        = when(route?.substringBefore("/")){
            HomeScreen.name -> HomeScreen
            DetailScreen.name->DetailScreen
            AllMovieScreen.name->AllMovieScreen

            else -> throw IllegalArgumentException("Route $route is not defined")
        }

    }
}