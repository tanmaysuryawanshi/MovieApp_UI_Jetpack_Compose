package com.tanmaysuryawanshi.movieapp.Screens.home


import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed

import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Card

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar

import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.unit.dp


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

import android.annotation.SuppressLint

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults

import androidx.compose.material3.Icon
import com.tanmaysuryawanshi.movieapp.model.Movie
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors

import androidx.compose.ui.Alignment

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tanmaysuryawanshi.movieapp.Navigation.MovieScreen
import com.tanmaysuryawanshi.movieapp.components.itemRow
import com.tanmaysuryawanshi.movieapp.model.getMovies

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar ={
            TopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor =  MaterialTheme.colorScheme.primaryContainer),
                title = {
                    Text(text = "Movie App",
                        color = MaterialTheme.colorScheme.onPrimaryContainer)
                }
            )
        }
    ) {
     MainContent(navController)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainContent(navController: NavController,
    movieList: List<Movie> = getMovies()
) {


    Column(modifier = Modifier
        .background(color = MaterialTheme.colorScheme.background)
        .padding(16.dp)) {
        Spacer(modifier = Modifier.height(56.dp))
        LazyColumn(modifier = Modifier.fillMaxSize()){
            items(items= movieList){
                    it->
                itemRow(it){movie ->
navController.navigate(MovieScreen.DetailScreen.name+"/$movie")
                }
            }
        }
    }
}


