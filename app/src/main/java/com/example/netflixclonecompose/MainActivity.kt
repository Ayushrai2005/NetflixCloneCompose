package com.example.netflixclonecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(

                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black)
                    .verticalScroll(rememberScrollState())

            ) {
                TopAppSection()
                NetflixContentChooser()
                featuredMovieSection()
                AddMovieList(movieType = "Action")
                AddMovieList(movieType = "Drama")
                AddMovieList(movieType = "Adventure")
                AddMovieList(movieType = "New releases")
                AddMovieList(movieType = "Shooting")
                AddMovieList(movieType = "watch it again")


            }

        }
    }


    @Composable

    fun TopAppSection() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Image(
                painter = painterResource(id = R.drawable.netfilx_logo),
                contentDescription = "Icon",
                modifier = Modifier
                    .padding(start = 6.dp, top = 6.dp)
                    .size(50.dp)

            )
            Row {
                Image(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = "search",
                    modifier = Modifier
                        .padding(end = 12.dp)
                        .size(38.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_profile),
                    contentDescription = "profile",
                    modifier = Modifier
                        .padding(end = 6.dp)
                        .size(38.dp)
                )

            }


        }

    }

    @Composable
    fun NetflixContentChooser() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(horizontal = 30.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Tv shows", color = Color.LightGray, fontSize = 20.sp)
            Text(text = "Movies", color = Color.LightGray, fontSize = 20.sp)

            Row {
                Text(text = "Categories", color = Color.LightGray, fontSize = 20.sp)

                Image(
                    painter = painterResource(id = R.drawable.ic_drop),
                    contentDescription = "Icon Drop"
                )
            }
        }
    }


    @Composable
    fun featuredMovieSection() {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(top = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.img3), contentDescription = "movie Logo",
                Modifier.size(350.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 60.dp, start = 80.dp, end = 80.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Adventure", color = Color.White)
                Text(text = "Action", color = Color.White)
                Text(text = "Thriller", color = Color.White)
                Text(text = "Drama", color = Color.White)
            }

            Row(
                modifier = Modifier
                    .padding(top = 20.dp, start = 70.dp, end = 70.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {


                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_add),
                        contentDescription = "movie Logo"
                    )
                    Text(text = "my List", color = Color.LightGray)
                }

                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(Color.White),
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Text(text = "Play", color = Color.Black, fontSize = 18.sp)

                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_info),
                        contentDescription = "movie Logo"
                    )
                    Text(text = "Info", color = Color.LightGray)
                }
            }
        }

    }
    @Composable
fun AddMovieList(movieType : String){


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
    ) {
        Text(text = movieType,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color.LightGray,
            modifier = Modifier.padding(top = 10.dp , start = 12.dp)

        )
        LazyRow(
            Modifier.padding(top = 4.dp)
        ){
            itemsIndexed(GetRandomMovie()){index, item ->
                MovieItemUiModel(imageRes = item.image)

            }

        }

    }
}

    @Composable
    fun MovieItemUiModel(
        imageRes : Int
    ){
        Image(painter = painterResource(id = imageRes),
            contentDescription = "",
            modifier = Modifier
                .height(200.dp)
                .width(120.dp)
        )

    }

    fun GetRandomMovie() : List<MovieItemModel>{
        val listofMovies = mutableListOf<MovieItemModel>()
        listofMovies.add(MovieItemModel(R.drawable.img9))
        listofMovies.add(MovieItemModel(R.drawable.img7))
        listofMovies.add(MovieItemModel(R.drawable.img6))
        listofMovies.add(MovieItemModel(R.drawable.img1))
        listofMovies.add(MovieItemModel(R.drawable.img4))
        listofMovies.add(MovieItemModel(R.drawable.img11))
        listofMovies.add(MovieItemModel(R.drawable.img10))
        listofMovies.add(MovieItemModel(R.drawable.img8))
        listofMovies.add(MovieItemModel(R.drawable.img5))
        listofMovies.add(MovieItemModel(R.drawable.img2))

        listofMovies.shuffle()
        return listofMovies
    }

}


data class MovieItemModel(val image: Int) {
}