package com.example.composemarvel.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.composemarvel.data.model.MarvelComics
import com.example.composemarvel.ui.theme.*
import com.example.composemarvel.R

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CharacterComicsItemList(
    character: MarvelComics,
) {
    Card(
        modifier = Modifier
            .width(135.dp)
            .height(225.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = 3.dp
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .background(SecondaryColor)
        ) {
            ImageCharacterItem(
                character.comicsThumbnail.thumbnailPath,
                character.comicsThumbnail.thumbnailExtension
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(5.dp)
            )
            Text(
                text = character.comicsName,
                color = PrimaryTextColor,
                fontSize = FontSizeTitleComicsName
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(5.dp)
            )
            Text(
                text = character.comicsModified.take(10),
                color = SecondaryTextColor,
                fontSize = FontSizeSmall
            )
        }
    }
}

@Composable
private fun ImageCharacterItem(
    characterThumbnail: String,
    character: String
) {
    val imageCoilRequest = ImageRequest.Builder(LocalContext.current)
        .data("$characterThumbnail.$character")
        .crossfade(true)
        .error(R.drawable.marvel_image_one)
        .build()
    Card(
        modifier = Modifier
            .height(135.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(10.dp)
    ) {
        AsyncImage(
            model = imageCoilRequest,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}