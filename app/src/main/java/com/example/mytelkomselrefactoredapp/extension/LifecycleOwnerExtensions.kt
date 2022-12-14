package com.example.mytelkomselrefactoredapp.extension

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mytelkomselrefactoredapp.presentation.viewmodel.StatefulResult
import com.google.gson.JsonObject

/**
 * Created by Rahmad Satria Kurniawan on 12/8/2022.
 * PT.Phincon
 * rahmad.kurniawan@phincon.com
 */

fun <T> LifecycleOwner.observe(liveData: LiveData<T>, observer: (T) -> Unit) {
    liveData.observe(
        this,
        {
            it?.let { t -> observer(t) }
        }
    )
}

fun <T> LifecycleOwner.observe(liveData: MutableLiveData<T>, observer: (T) -> Unit) {
    liveData.observe(
        this,
        {
            it?.let { t -> observer(t) }
        }
    )
}