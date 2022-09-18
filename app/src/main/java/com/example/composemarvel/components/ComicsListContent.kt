package com.example.composemarvel.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.composemarvel.data.model.MarvelComics
import com.example.composemarvel.util.Constants
import com.example.composemarvel.util.ScreenState

@Composable
fun ComicsListContent(
    marvelResults: List<MarvelComics>,
    screenState: ScreenState,
) {
    HandlerCharacterList(
        marvelResults = marvelResults,
        screenState = screenState
    )
}

@Composable
private fun HandlerCharacterList(
    marvelResults: List<MarvelComics>,
    screenState: ScreenState
) {
    when {
        marvelResults.isEmpty() -> DataLoadingScreen(screenState)
        else -> ListOfCharacters(marvelResults = marvelResults)
    }
}

@Composable
private fun ListOfCharacters(
    marvelResults: List<MarvelComics>,
) {
    LazyColumn(
        Modifier.fillMaxHeight(),
        contentPadding = PaddingValues(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(
            items = marvelResults,
            itemContent = { item ->
                ComicsItemList(comics = item)
            }
        )
    }
}