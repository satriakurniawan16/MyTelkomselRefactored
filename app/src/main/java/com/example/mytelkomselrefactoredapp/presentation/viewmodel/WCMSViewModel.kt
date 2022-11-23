package com.example.mytelkomselrefactoredapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import com.example.mytelkomselrefactoredapp.domain.interactor.GetAllTranslationUseCase
import com.example.mytelkomselrefactoredapp.presentation.utils.CoroutineContextProvider
import com.example.mytelkomselrefactoredapp.presentation.utils.StatefulLiveData
import com.example.mytelkomselrefactoredapp.util.ExceptionHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import javax.inject.Inject
import kotlinx.coroutines.flow.collect

@HiltViewModel
class WCMSViewModel @Inject constructor(
    contextProvider: CoroutineContextProvider,
    private val getAllTranslationUseCase: GetAllTranslationUseCase
) : BaseViewModel(contextProvider) {
    private val _translation = StatefulLiveData<StatefulResult<String>>()
    private val translation: LiveData<StatefulResult<String>> = _translation

    fun getTranslation(): LiveData<StatefulResult<String>> {
        return translation
    }

    override val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
        _translation.postValue(StatefulResult.Failed(exception.message ?: ""))
    }

    fun getTranslations() {
        _translation.postValue(StatefulResult.Loading)
        launchCoroutineIO {
            loadAllTranslation()
        }
    }

    private suspend fun loadAllTranslation() {
        getAllTranslationUseCase(Unit).collect() {
            _translation.postValue(StatefulResult.Success(it))
        }
    }
}