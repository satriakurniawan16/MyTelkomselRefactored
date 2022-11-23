package com.example.mytelkomselrefactoredapp.presentation.utils

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

class StatefulLiveData<T: LiveDataAwareModel>: MutableLiveData<T>() {
    private  var previousValue: T? = null
    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        super.observe(owner) {
            value?.isRedeliverd = false
            val inProperState =
                owner.lifecycle.currentState == Lifecycle.State.CREATED || owner.lifecycle.currentState == Lifecycle.State.STARTED
            if (previousValue == value && inProperState) {
                value?.isRedeliverd = true
            }
            observer.onChanged(value)
            previousValue = value
        }
    }
}