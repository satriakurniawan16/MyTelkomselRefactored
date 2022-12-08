package com.example.mytelkomselrefactoredapp.view.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.mytelkomselrefactoredapp.R
import com.example.mytelkomselrefactoredapp.domain.models.Faq
import com.example.mytelkomselrefactoredapp.extension.observe
import com.example.mytelkomselrefactoredapp.presentation.viewmodel.BaseViewModel
import com.example.mytelkomselrefactoredapp.presentation.viewmodel.StatefulResult
import com.example.mytelkomselrefactoredapp.presentation.viewmodel.WCMSViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<BaseViewModel>() {

    override val viewModel: WCMSViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getTranslations()
        viewModel.getFaqData()
        observe(viewModel.getFaq(), :: onFaqViewStateChange)
        observe(viewModel.getTranslation(),:: onViewStateChange)
        viewModel.getTranslation().observe(this) { Log.d("MAMA", "onCreate: $it") }
    }

    private fun onFaqViewStateChange(event : StatefulResult<Faq>) {
        if(event.isRedeliverd) return
        when(event){
            is StatefulResult.Failed -> ""
            is StatefulResult.Loading -> handleLoading(false)
            is StatefulResult.Success ->{
                Log.d("Mama", "onFaqViewStateChange: ${event.data}")
                event.data.let {
                    Log.d("Mama", "onFaqViewStateChange: ${it.en}")
                }
            }
        }
        Log.d("MAMAYUKARO", "onViewStateChange: $event")
    }

    private fun onViewStateChange(event: StatefulResult<String>) {
        if (event.isRedeliverd) return
        Log.d("MAMAYUKARO2", "onViewStateChange: $event")
        when (event) {
            is StatefulResult.Failed -> ""
            is StatefulResult.Loading -> handleLoading(true)
                    is StatefulResult.Success -> {
                event.data.let {
                    Log.d("MAMA", "onViewStateChange: ${it.toString()}")
                }
            }
        }
    }

}