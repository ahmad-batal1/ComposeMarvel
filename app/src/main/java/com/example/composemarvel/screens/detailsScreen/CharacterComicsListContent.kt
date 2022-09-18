package com.example.composemarvel.screens.detailsScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composemarvel.data.model.MarvelComics
import com.example.composemarvel.components.CharacterComicsItemList
import com.example.composemarvel.components.DataLoadingScreen
import com.example.composemarvel.util.ScreenState

@Composable
fun CharacterComicsListContent(
    marvelResults: List<MarvelComics>
) {
    HandlerCharacterList(marvelResults)
}

@Composable
private fun HandlerCharacterList(
    marvelResults: List<MarvelComics>
) {
    when {
        marvelResults.isEmpty() -> DataLoadingScreen(ScreenState.Home)
        else -> ListOfComics(marvelResults = marvelResults)
    }
}

@Composable
private fun ListOfComics(
    marvelResults: List<MarvelComics>,
) {
    LazyRow(
        Modifier.fillMaxHeight(),
        contentPadding = PaddingValues(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        items(
            items = marvelResults,
            itemContent = { item ->
                CharacterComicsItemList(character = item)
            }
        )
    }
}