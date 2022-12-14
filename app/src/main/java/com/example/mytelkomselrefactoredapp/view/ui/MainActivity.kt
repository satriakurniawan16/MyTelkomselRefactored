package com.example.mytelkomselrefactoredapp.view.ui


import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.mytelkomselrefactoredapp.R
import com.example.mytelkomselrefactoredapp.core.base.BaseActivity
import com.example.mytelkomselrefactoredapp.domain.models.Faq
import com.example.mytelkomselrefactoredapp.core.base.BaseViewModel
import com.example.mytelkomselrefactoredapp.core.extensions.StatefulResult
import com.example.mytelkomselrefactoredapp.databinding.ActivityMainBinding
import com.example.mytelkomselrefactoredapp.extension.observe
import com.example.mytelkomselrefactoredapp.presentation.viewmodel.WCMSViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Rahmad Satria Kurniawan on 12/8/2022.
 * PT.Phincon
 * rahmad.kurniawan@phincon.com
 */

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, BaseViewModel>() {

    override val viewModel: WCMSViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getTranslations()
        viewModel.getFaqData()
        observe(viewModel.getFaq(), ::onFaqViewStateChange)
        observe(viewModel.getTranslation(), ::onViewStateChange)
        viewModel.getTranslation().observe(this) { Log.d("MAMA", "onCreate: $it") }
    }

    private fun onFaqViewStateChange(event: StatefulResult<Faq>) {
        if (event.isRedeliverd) return
        when (event) {
            is StatefulResult.Failed -> ""
            is StatefulResult.Loading -> handleLoading(false)
            is StatefulResult.Success -> {
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

    override fun getViewBinding() = ActivityMainBinding.inflate(layoutInflater)

}