package com.example.composemarvel.screens.homeScreen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.composemarvel.screens.base.BaseViewModel
import com.example.composemarvel.data.model.MarvelCharacterResponse
import com.example.composemarvel.data.network.MarvelRepositoryImpl
import com.example.composemarvel.util.State
import com.example.composemarvel.util.addTo
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class HomeScreenViewModel : BaseViewModel() {

    private val marvelRepository = MarvelRepositoryImpl()

    private val _marvelCharacters = MutableLiveData<State<MarvelCharacterResponse>>()
    val marvelCharacters: LiveData<State<MarvelCharacterResponse>>
        get() = _marvelCharacters

    init {
        marvelRepository
            .getListOfMarvelCharacters()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(::onSuccessGetCharacters, ::onErrorUpdateQuestion).addTo(disposable)
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