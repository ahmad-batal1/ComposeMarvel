package com.example.composemarvel.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composemarvel.screens.searchScreen.SharedSearchCharactersViewModel
import com.example.composemarvel.ui.theme.PrimaryColor
import com.example.composemarvel.ui.theme.SecondaryColor
import com.example.composemarvel.ui.theme.SecondaryTextColor
import com.example.composemarvel.util.SearchAppBarState

@Composable
fun SearchCharacters(
    sharedViewModel: SharedSearchCharactersViewModel,
    searchAppBarState: SearchAppBarState,
    searchTextState: String
) {
    when (searchAppBarState) {
        SearchAppBarState.CLOSED -> {
            DefaultListAppBar(
                onSearchClicked = {
                    sharedViewModel.searchCharactersState.value = SearchAppBarState.OPENED
                },
            )
        }
        else -> {
            SearchAppBar(
                text = searchTextState,
                onTextChange = { newText ->
                    sharedViewModel.searchTextState.value = newText
                },
                onCloseClicked = {
                    sharedViewModel.searchCharactersState.value = SearchAppBarState.CLOSED
                    sharedViewModel.searchTextState.value = ""
                },
                onSearchClicked = {
                    sharedViewModel.getCharacterComicsByCharacterId(characterName = it)
                }
            )
        }
    }
}

@Composable
fun DefaultListAppBar(
    onSearchClicked: () -> Unit,
) {
    Card(
        Modifier
            .fillMaxWidth()
            .height(56.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = 2.dp
    ) {
        Row(
            Modifier
                .fillMaxSize()
                .background(SecondaryTextColor),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(
                modifier =
                Modifier
                    .fillMaxHeight()
                    .width(10.dp)
            )
            Text(
                text = "Search Characters",
                color = PrimaryColor,
                fontSize = 16.sp,
                modifier = Modifier.wrapContentWidth()
            )
            Row(
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                SearchAction(onSearchClicked = onSearchClicked)
                Spacer(modifier = Modifier.width(10.dp))
            }
        }
    }
}

@Composable
fun SearchAction(
    onSearchClicked: () -> Unit
) {
    IconButton(
        onClick = {
            onSearchClicked()
        }
    ) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = "character name",
            tint = SecondaryColor
        )
    }
}

@Composable
fun SearchAppBar(
    text: String,
    onTextChange: (String) -> Unit,
    onCloseClicked: () -> Unit,
    onSearchClicked: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(PrimaryColor),
        shape = RoundedCornerShape(20.dp),
        elevation = 15.dp,
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .background(SecondaryTextColor),
            value = text,
            onValueChange = {
                onTextChange(it)
            },
            placeholder = {
                Text(
                    modifier = Modifier
                        .alpha(ContentAlpha.medium),
                    text = "Character Name",
                    color = PrimaryColor
                )
            },
            textStyle = TextStyle(
                color = PrimaryColor,
                fontSize = 15.sp
            ),
            singleLine = true,
            leadingIcon = {
                IconButton(
                    modifier = Modifier
                        .alpha(ContentAlpha.disabled),
                    onClick = {}
                ) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Search Character",
                        tint = PrimaryColor
                    )
                }
            },
            trailingIcon = {
                IconButton(
                    onClick = {
                        if (text.isNotEmpty())
                            onTextChange("")
                        else onCloseClicked()
                    }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = "closeIcon",
                        tint = PrimaryColor
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    onSearchClicked(text)
                }
            ),
            colors = TextFieldDefaults.textFieldColors(
                cursorColor = PrimaryColor,
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                backgroundColor = Color.Transparent
            )
        )
    }
}

@Composable
@Preview
private fun DefaultListAppBarPreview() {
    DefaultListAppBar(
        onSearchClicked = {},
    )
}

@Composable
@Preview
private fun SearchAppBarPreview() {
    SearchAppBar(
        text = "",
        onTextChange = {},
        onCloseClicked = {},
        onSearchClicked = {}
    )
}