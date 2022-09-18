package com.example.composemarvel.screens.favoriteScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composemarvel.components.ComicsListContent
import com.example.composemarvel.ui.theme.PrimaryColor
import com.example.composemarvel.util.ScreenState

@Composable
fun FavoritePage(
    favoriteViewModel: FavoriteCharacterViewModel = viewModel()
) {
    val comicsResponse = favoriteViewModel.marvelComics.observeAsState()
    val comics = comicsResponse.value?.toData()?.marvelDataResponse?.MarvelResult

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PrimaryColor),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ComicsListContent(comics.orEmpty(), ScreenState.Home)
    }
}