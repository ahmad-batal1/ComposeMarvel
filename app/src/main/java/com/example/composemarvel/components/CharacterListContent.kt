package com.example.composemarvel.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.composemarvel.data.model.MarvelCharacter
import com.example.composemarvel.util.Constants.CHARACTER_DETAILS_PARCELABLE
import com.example.composemarvel.util.Constants.DETAILS_ROUTE
import com.example.composemarvel.util.ScreenState

@Composable
fun CharacterListContent(
    navController: NavHostController,
    marvelResults: List<MarvelCharacter>,
    screenState: ScreenState,
    ) {
    HandlerCharacterList(
        navController = navController,
        marvelResults = marvelResults,
        screenState = screenState
    )
}

@Composable
private fun HandlerCharacterList(
    navController: NavHostController,
    marvelResults: List<MarvelCharacter>,
    screenState: ScreenState
) {
    when {
        marvelResults.isEmpty() -> DataLoadingScreen(screenState)
        else -> ListOfCharacters(navController,marvelResults = marvelResults)
    }
}

@Composable
private fun ListOfCharacters(
    navController: NavHostController,
    marvelResults: List<MarvelCharacter>,
) {
    LazyColumn(
        Modifier.fillMaxHeight(),
        contentPadding = PaddingValues(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(
            items = marvelResults,
            itemContent = { item ->
                CharacterItemList(character = item, onItemClick = {
                    navController.currentBackStackEntry?.savedStateHandle?.set(
                        key = CHARACTER_DETAILS_PARCELABLE,
                        value = it
                    )
                    navController.navigate(DETAILS_ROUTE)
                })
            }
        )
    }
}