package com.example.mytelkomselrefactoredapp.view.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mytelkomselrefactoredapp.R
import com.example.mytelkomselrefactoredapp.presentation.viewmodel.BaseViewModel

abstract class BaseActivity<ViewModel: BaseViewModel> : AppCompatActivity() {

    protected abstract val viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        observerEvents()
    }

    private fun observerEvents(){
        viewModel.apply {

        }
    }

    protected open fun handleLoading(isLoading: Boolean) {
//        if (isLoading) showLoadingDialog() else dismissLoadingDialog()
    }


}