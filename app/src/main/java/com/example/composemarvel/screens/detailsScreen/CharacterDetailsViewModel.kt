package com.example.composemarvel.screens.detailsScreen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.composemarvel.screens.base.BaseViewModel
import com.example.composemarvel.data.model.MarvelComicsResponse
import com.example.composemarvel.data.network.MarvelRepositoryImpl
import com.example.composemarvel.util.State
import com.example.composemarvel.util.addTo
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class CharacterDetailsViewModel: BaseViewModel() {
    private val marvelRepository = MarvelRepositoryImpl()

    private val _marvelCharacterComics = MutableLiveData<State<MarvelComicsResponse>>()
    val marvelCharacterComics: LiveData<State<MarvelComicsResponse>>
        get() =_marvelCharacterComics


    fun getCharacterComicsByCharacterId(characterId:String){
        marvelRepository.getComicsCharacterByCharacterId(characterId)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(::onSuccessGetCharacters,::onErrorUpdateQuestion).addTo(disposable)
    }

    private fun onSuccessGetCharacters(state: State<MarvelComicsResponse>) {
        state.toData()?.let {
            _marvelCharacterComics.postValue(State.Success(it))
        }
    }

    private fun onErrorUpdateQuestion(throwable: Throwable) {
        Log.d("Throwable", "${throwable.message}")
    }
}