package com.example.composemarvel.screens.homeScreen

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.composemarvel.BaseViewModel
import com.example.composemarvel.data.model.MarvelResponse
import com.example.composemarvel.data.network.MarvelRepository
import com.example.composemarvel.data.network.MarvelRepositoryImpl
import com.example.composemarvel.util.State
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class HomeScreenViewModel : BaseViewModel() {
    private val marvelRepository = MarvelRepositoryImpl()

//    private val mutabl = MutableLiveData<State<MarvelResponse>>()
//    val

    init {
        marvelRepository
            .getListOfMarvelCharacters()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(::onSuccessGetCharacters, ::onErrorUpdateQuestion)
    }

    private fun onSuccessGetCharacters(state: State<MarvelResponse>) {
        state.toData()?.let {
        }
    }

    private fun onErrorUpdateQuestion(throwable: Throwable) {
        Log.d("Throwable", "${throwable.message}")
    }
}