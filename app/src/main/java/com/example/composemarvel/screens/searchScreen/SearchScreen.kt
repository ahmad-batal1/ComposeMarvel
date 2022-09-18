package com.example.composemarvel.screens.searchScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.composemarvel.components.SearchCharacters
import com.example.composemarvel.components.CharacterListContent
import com.example.composemarvel.ui.theme.PrimaryColor
import com.example.composemarvel.util.ScreenState
import com.example.composemarvel.util.SearchAppBarState

@Composable
fun SearchPage(
    navController:NavHostController,
    searchCharactersViewModel: SharedSearchCharactersViewModel= viewModel()
) {
    val searchAppBarState: SearchAppBarState by searchCharactersViewModel.searchCharactersState
    val searchTextState: String by searchCharactersViewModel.searchTextState
    val characterResponse = searchCharactersViewModel.marvelCharacters.observeAsState()
    val characters = characterResponse.value?.toData()?.marvelDataResponse?.MarvelResult

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PrimaryColor),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(15.dp))
        SearchCharacters(
            sharedViewModel = searchCharactersViewModel,
            searchAppBarState = searchAppBarState,
            searchTextState = searchTextState
        )
        CharacterListContent(
            navController = navController,
            marvelResults = characters.orEmpty(),
            screenState = ScreenState.Search
        )
    }
}