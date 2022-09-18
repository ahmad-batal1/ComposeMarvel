package com.example.composemarvel.screens.detailsScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.composemarvel.R
import com.example.composemarvel.data.model.CharacterThumbnail
import com.example.composemarvel.data.model.MarvelCharacter
import com.example.composemarvel.ui.theme.*
import com.example.composemarvel.util.Constants
import com.example.composemarvel.util.Constants.Comics

@Composable
fun CharacterDetailsScreen(
    navController: NavHostController,
    homeViewModel: CharacterDetailsViewModel = viewModel()
) {
    val marvelCharacter = navController.previousBackStackEntry?.savedStateHandle?.get<MarvelCharacter>(Constants.CHARACTER_DETAILS_PARCELABLE)

    marvelCharacter?.let { character ->

        homeViewModel.getCharacterComicsByCharacterId(characterId = character.characterId)
        val comicsResponse = homeViewModel.marvelCharacterComics.observeAsState()
        val comics = comicsResponse.value?.toData()?.marvelDataResponse?.MarvelResult

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(PrimaryColor),
        ) {

            HeaderAndCharacterImage(character.characterThumbnail)

            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(10.dp))

            Row(Modifier.fillMaxWidth()) {
                Spacer(modifier = Modifier.width(15.dp))
                Text(
                    text = character.characterName,
                    fontSize = FontSizeTitleCharacterName,
                    color = PrimaryTextColor
                )
            }

            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(10.dp))

            Row(Modifier.fillMaxWidth()) {
                Spacer(modifier = Modifier.width(15.dp))
                Text(
                    text = character.characterModified.take(10),
                    fontSize = FontSizeTitleListNameCharacter,
                    color = SecondaryColor
                )
            }

            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(10.dp))

            Row(Modifier.fillMaxWidth()) {
                Spacer(modifier = Modifier.width(15.dp))
                Text(
                    text = Comics,
                    fontSize = FontSizeTitleListNameCharacter,
                    color = SecondaryColor
                )
            }
            
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(5.dp))

            CharacterComicsListContent(marvelResults = comics.orEmpty())
        }
    }
}

@Composable
private fun HeaderAndCharacterImage(
    characterThumbnail: CharacterThumbnail
) {
    Box(
        Modifier
            .fillMaxWidth()
            .height(320.dp)
    ) {
        HeaderImageDetailsScreen()
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.Bottom
        ) {
            Spacer(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(15.dp)
            )
            ImageCharacterItem(characterThumbnail)
        }
    }
}

@Preview
@Composable
private fun HeaderImageDetailsScreen() {
    val listOfImagesBackground = listOf(
        R.drawable.marvel_image_one,
        R.drawable.marvel_image_two,
        R.drawable.marvel_image_three,
        R.drawable.marvel_image_four,
        R.drawable.marvel_image_fife,
    )
    val getImageFromImagesBackGroundList = listOfImagesBackground.random()
    Image(
        painter = painterResource(id = getImageFromImagesBackGroundList),
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .height(210.dp),
        contentScale = ContentScale.Crop
    )
}

@Composable
private fun ImageCharacterItem(
    characterThumbnail: CharacterThumbnail,
) {
    val imageCoilRequest = ImageRequest.Builder(LocalContext.current)
        .data("${characterThumbnail.thumbnailPath}.${characterThumbnail.thumbnailExtension}")
        .crossfade(true)
        .build()
    Card(
        modifier = Modifier
            .height(190.dp)
            .width(160.dp),
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