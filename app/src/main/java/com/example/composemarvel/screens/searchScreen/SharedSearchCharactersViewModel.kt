package com.example.composemarvel.screens.searchScreen

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.composemarvel.data.model.MarvelCharacterResponse
import com.example.composemarvel.data.network.MarvelRepositoryImpl
import com.example.composemarvel.screens.base.BaseViewModel
import com.example.composemarvel.util.SearchAppBarState
import com.example.composemarvel.util.State
import com.example.composemarvel.util.addTo
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class SharedSearchCharactersViewModel: BaseViewModel() {
    private val marvelRepository = MarvelRepositoryImpl()

    private val _marvelCharacters = MutableLiveData<State<MarvelCharacterResponse>>()
    val marvelCharacters: LiveData<State<MarvelCharacterResponse>>
        get() =_marvelCharacters

    val searchTextState: MutableState<String> = mutableStateOf("")
    val searchCharactersState: MutableState<SearchAppBarState> = mutableStateOf(SearchAppBarState.CLOSED)

    fun getCharacterComicsByCharacterId(characterName:String){
        marvelRepository.getMarvelCharactersByCharacterName(characterName)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(::onSuccessGetCharacters,::onErrorUpdateQuestion).addTo(disposable)
    }

    private fun onSuccessGetCharacters(state: State<MarvelCharacterResponse>) {
        state.toData()?.let {
            _marvelCharacters.postValue(State.Success(it))
        }
    }

    private fun onErrorUpdateQuestion(throwable: Throwable) {
        Log.d("Throwable", "${throwable.message}")
    }
}