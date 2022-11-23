package com.example.mytelkomselrefactoredapp.view.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.mytelkomselrefactoredapp.R
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
        observe(viewModel.getTranslation(),:: onViewStateChange)
        viewModel.getTranslation().observe(this) { Log.d("MAMA", "onCreate: $it") }
    }

    private fun onViewStateChange(event: StatefulResult<String>) {
        if (event.isRedeliverd) return
        Log.d("MAMAYUKARO", "onViewStateChange: $event")
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