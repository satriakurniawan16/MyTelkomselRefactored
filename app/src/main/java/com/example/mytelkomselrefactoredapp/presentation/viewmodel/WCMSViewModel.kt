package com.example.mytelkomselrefactoredapp.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.mytelkomselrefactoredapp.core.base.BaseViewModel
import com.example.mytelkomselrefactoredapp.domain.interactor.GetAllTranslationUseCase
import com.example.mytelkomselrefactoredapp.domain.interactor.GetFaqUseCase
import com.example.mytelkomselrefactoredapp.domain.models.Faq
import com.example.mytelkomselrefactoredapp.presentation.utils.CoroutineContextProvider
import com.example.mytelkomselrefactoredapp.core.extensions.StatefulLiveData
import com.example.mytelkomselrefactoredapp.core.extensions.StatefulResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import javax.inject.Inject

@HiltViewModel
class WCMSViewModel @Inject constructor(
    contextProvider: CoroutineContextProvider,
    private val getAllTranslationUseCase: GetAllTranslationUseCase,
    private val getFaqUseCase: GetFaqUseCase,
) : BaseViewModel(contextProvider) {

    private val _translation = StatefulLiveData<StatefulResult<String>>()
    private val translation: LiveData<StatefulResult<String>> = _translation

    private val _faq = StatefulLiveData<StatefulResult<Faq>>()
    private val faq: LiveData<StatefulResult<Faq>> = _faq

    fun getTranslation(): LiveData<StatefulResult<String>> {
        return translation
    }

    fun getFaq(): LiveData<StatefulResult<Faq>>{
        return faq
    }


    override val coroutineExceptionHandler = CoroutineExceptionHandler { data, exception ->
        Log.d("MAMALOL", "${data.toString()}")
        _translation.postValue(StatefulResult.Failed(exception.message ?: ""))
//        _faq.postValue(StatefulResult.Failed(exception.message ?: ""))
    }

    fun getFaqData(){
        _faq.postValue(StatefulResult.Loading)
        launchCoroutineIO {
            loadFaq()
        }
    }

    private suspend fun loadFaq(){
        getFaqUseCase(Unit).collect() {
            _faq.postValue(StatefulResult.Success(it))
        }
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