package com.example.artspaceapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ArtSpaceItem(imageResId: Int, title: String, artist: String) {
    Surface(
        modifier = Modifier
            .padding(8.dp)
            .border(1.dp, Color(0xFF000000), shape = RoundedCornerShape(4.dp))
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = artist,
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = { /* Handle button click */ },
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(text = "Add to Favorites")
            }
        }
    }
}

@Composable
fun ArtList() {
    val artList = listOf(
        ArtItem(
            imageResId = R.drawable.monet1,
            title = "Woman with an Umbrella",
            artist = "Monet"
        ),
        ArtItem(
            imageResId = R.drawable.monet2,
            title = "Bridge",
            artist = "Monet"
        ),
        ArtItem(
            imageResId = R.drawable.monet3,
            title = "Sunset",
            artist = "Monet"
        ),
        ArtItem(
            imageResId = R.drawable.monet4,
            title = "Garden",
            artist = "Monet"
        ),
        ArtItem(
            imageResId = R.drawable.monet5,
            title = "Mother and son",
            artist = "Monet"
        )
    )

    LazyColumn(
        modifier = Modifier.padding(8.dp)
    ) {
        items(artList) { artItem ->
            ArtSpaceItem(
                imageResId = artItem.imageResId,
                title = artItem.title,
                artist = artItem.artist
            )
        }
    }
}


@Preview
@Composable
fun DefaultPreview() {
    ArtSpaceApp()
}

@Composable
fun ArtSpaceApp() {
    Surface(color = Color.White) {
        ArtList()
    }
}

data class ArtItem(
    val imageResId: Int,
    val title: String,
    val artist: String
)
