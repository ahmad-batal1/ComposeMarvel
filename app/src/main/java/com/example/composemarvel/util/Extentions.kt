package com.example.composemarvel.util

import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import java.math.BigInteger
import java.security.MessageDigest

fun Disposable.addTo(compositeDisposable: CompositeDisposable) {
    compositeDisposable.add(this)
}

fun String.md5(): String {
    val messageDigest = MessageDigest.getInstance("md5")
    return BigInteger(1, messageDigest.digest(toByteArray())).toString(16).padStart(32, '0')
}