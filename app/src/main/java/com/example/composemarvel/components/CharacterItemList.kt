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
import com.example.composemarvel.data.model.MarvelCharacter
import com.example.composemarvel.ui.theme.*

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CharacterItemList(
    character: MarvelCharacter,
    onItemClick: (MarvelCharacter) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(110.dp),
        shape = RoundedCornerShape(17.dp),
        elevation = 2.dp,
        onClick = {
            onItemClick(character)
        }
    ) {
        Row(
            Modifier
                .fillMaxSize()
                .background(SecondaryColor)
        ) {
            ImageCharacterItem(
                character.characterThumbnail.thumbnailPath,
                character.characterThumbnail.thumbnailExtension
            )
            Column(
                Modifier
                    .fillMaxHeight()
                    .padding(10.dp)
            ) {
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(5.dp)
                )
                Text(
                    text = character.characterName,
                    color = PrimaryTextColor,
                    fontSize = FontSizeTitleListNameCharacter
                )
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(17.dp)
                )
                Text(
                    text = character.characterModified.take(10),
                    color = SecondaryTextColor,
                    fontSize = FontSizeMedium
                )
            }
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
        .build()
    Card(
        modifier = Modifier
            .fillMaxHeight()
            .width(90.dp)
            .padding(10.dp),
        shape = RoundedCornerShape(15.dp)
    ) {
        AsyncImage(
            model = imageCoilRequest,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}