package com.tanmaysuryawanshi.movieapp.Screens.allmovie


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.items

import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar

import androidx.compose.ui.unit.dp


import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

import android.annotation.SuppressLint
import androidx.compose.foundation.ScrollState

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.Alignment

import com.tanmaysuryawanshi.movieapp.model.Movie

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.tanmaysuryawanshi.movieapp.components.MovieRowItem
import com.tanmaysuryawanshi.movieapp.model.getMovies

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun allmovie(navController: NavController) {
    Scaffold(
        topBar ={
            TopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor =MaterialTheme.colorScheme.background),
                title = {
                    Text(text = "Netflix",
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 34.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .navigationBarsPadding(),
                    textAlign = TextAlign.Center)
                }
            )
        },
        content =  {
            ContentAllMovie(navController, paddingValues = it)}
    )
}

@Composable
fun ContentAllMovie(navController: NavController,
      movieList: List<Movie> = getMovies(),
paddingValues: PaddingValues) {


Column(
    Modifier
        .padding(paddingValues)
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background)
        .verticalScroll(state = rememberScrollState())) {


    sectionMovie(movieList,"Trending","Find the latest movie")
    sectionMovie(movieList.filter {
                                  it.genre.contains("Sci-Fi")
    },"Sci-Fi","Best Scifi films of all times")
    sectionMovie(movieList
        .filter {
            it.genre.contains("Action")
        },"Continue watching","Start where you left")

}


}

@Composable
private fun sectionMovie(movieList: List<Movie>, s: String, s1: String) {
    Spacer(modifier = Modifier.height(16.dp))
    Row(horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.Bottom,
    modifier = Modifier.fillMaxWidth()) {
        Column() {
            Text(
                text = s,
                modifier = Modifier.padding(start = 16.dp),
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily.SansSerif,
                color = MaterialTheme.colorScheme.secondary,
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = s1,
                modifier = Modifier.padding(start = 16.dp),
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Normal,
                color = Color(0xFFB4B4B4),
                fontSize = 16.sp
            )
        }
        Text(
            text = "See more",
            modifier = Modifier.padding(end=16.dp),
            fontFamily = FontFamily.SansSerif,
            color = MaterialTheme.colorScheme.primary,
            fontSize = 14.sp
        )
    }


    Spacer(modifier = Modifier.height(16.dp))
    LazyRow {
        items(movieList) {
            MovieRowItem(it)
        }

    }
}

