package com.example.mytelkomselrefactoredapp.core.extensions

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

/**
 * Created by Rahmad Satria Kurniawan on 12/8/2022.
 * PT.Phincon
 * rahmad.kurniawan@phincon.com
 */

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