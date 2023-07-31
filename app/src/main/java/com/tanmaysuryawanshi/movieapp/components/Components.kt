package com.tanmaysuryawanshi.movieapp.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.tanmaysuryawanshi.movieapp.model.Movie
import com.tanmaysuryawanshi.movieapp.model.getMovies

@Composable
fun itemRow(it: Movie= getMovies()[0], onItemClick:(String)->Unit ={}) {

    var expanded=remember{
        mutableStateOf(false)
    }
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(160.dp)
        .padding(8.dp)
        .clickable {
            onItemClick(it.id)
        }
        , elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)) {

Box(modifier = Modifier.fillMaxSize())
{

    Image(painter = rememberAsyncImagePainter(model = it.images[0]), contentDescription = null,
        modifier = Modifier
            .fillMaxSize(),
    contentScale = ContentScale.Crop)

Box(modifier = Modifier
    .fillMaxSize()
    .background(
        brush = Brush.horizontalGradient(
            colors = listOf(
                MaterialTheme.colorScheme.onPrimaryContainer, Color.Transparent
            )
        )
    ))
    Box(modifier =  Modifier.fillMaxSize()
    ){
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
                .verticalScroll(state = rememberScrollState()),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {



            Column( modifier = Modifier

                .padding(4.dp)) {
                Text(text = it.title,
                    color = MaterialTheme.colorScheme.surface,
                    style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = it.director,
                    color = MaterialTheme.colorScheme.surface,
                    style = MaterialTheme.typography.bodyMedium)
                Text(text = it.genre,
                    color = MaterialTheme.colorScheme.surface,
                    style = MaterialTheme.typography.labelMedium)
                Spacer(modifier = Modifier.height(4.dp))
                AnimatedVisibility(visible = expanded.value) {
                    Text(text = it.plot,
                        color = MaterialTheme.colorScheme.surface,
                        style = MaterialTheme.typography.bodySmall)
                }


            }


            
            Icon(imageVector = if(expanded.value){Icons.Default.KeyboardArrowUp}
                else{Icons.Default.KeyboardArrowDown},
                contentDescription = "arrow down",
                tint = MaterialTheme.colorScheme.surface,
                modifier = Modifier
                    .size(40.dp)
                    .align(Alignment.Bottom)
                    .clickable {
                        expanded.value = !expanded.value
                    }

            )
        }
    }
}



    }
}


@Preview
@Composable
fun MovieRowItem(it: Movie= getMovies()[0]) {

Box(modifier = Modifier.padding(horizontal = 16.dp)){

Card(shape = RoundedCornerShape(16.dp),

modifier = Modifier
    .shadow(
        elevation = 4.dp,
        ambientColor = Color(0xFFB4B4B4),
        spotColor = Color(0xFFB4B4B4)
    )
    .height(240.dp)
    .width(160.dp),
colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary)) {
Box(modifier = Modifier.fillMaxSize()){
    Image(painter = rememberAsyncImagePainter(model = it.images[0]), contentDescription = null,
        modifier = Modifier
            .fillMaxSize(),
        contentScale = ContentScale.Crop)

    Box(modifier = Modifier
        .fillMaxSize()
        .background(
            brush = Brush.verticalGradient(
                colors = listOf(
                    Color.Transparent, MaterialTheme.colorScheme.background
                )
            )
        ))

    Box(modifier = Modifier
        .fillMaxSize()
      ){
       Column(modifier = Modifier
           .fillMaxWidth()
           .height(90.dp)
           .padding(16.dp)
           .align(Alignment.BottomCenter),
        horizontalAlignment =Alignment.Start ,
        verticalArrangement = Arrangement.SpaceBetween ){


            Text(text = it.title,
                color = MaterialTheme.colorScheme.secondary,
                fontFamily = FontFamily.SansSerif,
                fontSize = 18.sp,
                modifier = Modifier

            )
           Spacer(modifier = Modifier.height(4.dp))
            Text(text = it.year,
                color = Color(0xFFB4B4B4),
                fontFamily = FontFamily.SansSerif,
                fontSize = 14.sp,
                modifier = Modifier

            )
        }


    }

}



    
}


}

}
