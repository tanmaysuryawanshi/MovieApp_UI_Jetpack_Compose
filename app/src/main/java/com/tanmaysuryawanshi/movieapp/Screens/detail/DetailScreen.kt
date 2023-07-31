package com.tanmaysuryawanshi.movieapp.Screens.detail

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(navController: NavController, string: String?) {
    
   Scaffold(
       topBar = {
           TopAppBar (title = {
               Row(horizontalArrangement = Arrangement.Start) {
                   Icon(imageVector = Icons.Default.ArrowBack,
                       contentDescription =null ,
                   modifier = Modifier.clickable { 
                       navController.popBackStack()
                   },
                   tint =  MaterialTheme.colorScheme.onPrimaryContainer)
                   Spacer(modifier = Modifier.width(100.dp))
                   Text(text = "Movies",
                       color = MaterialTheme.colorScheme.onPrimaryContainer)
               }
           },
           colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = MaterialTheme.colorScheme.primaryContainer))
       }
   ) {


       Column(horizontalAlignment = Alignment.CenterHorizontally,
           verticalArrangement = Arrangement.Center,
           modifier = Modifier
               .fillMaxSize()
               .background(color = MaterialTheme.colorScheme.surface)) {

           Text(text=string.toString(),
               style = MaterialTheme.typography.headlineLarge,
               color = MaterialTheme.colorScheme.onSurface
           )

//           Button(onClick = {
//               navController.popBackStack()
//
//           },
//           colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)) {
//               Text(text = "Go Back",
//               color = MaterialTheme.colorScheme.onPrimary)
//
//           }
       }

   }
    
    
    


}