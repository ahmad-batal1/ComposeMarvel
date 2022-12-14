package com.example.composemarvel.screens.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.composemarvel.components.CharacterListContent
import com.example.composemarvel.ui.theme.PrimaryColor
import com.example.composemarvel.util.ScreenState

@Composable
fun HomePage(
    navController: NavHostController,
    homeViewModel: HomeScreenViewModel = viewModel()
) {
    val characterResponse = homeViewModel.marvelCharacters.observeAsState()
    val characters = characterResponse.value?.toData()?.marvelDataResponse?.MarvelResult
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PrimaryColor),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CharacterListContent(navController,characters.orEmpty(),ScreenState.Home)
    }
}