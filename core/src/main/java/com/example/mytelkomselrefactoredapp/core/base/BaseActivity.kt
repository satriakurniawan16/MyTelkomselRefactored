package com.example.mytelkomselrefactoredapp.core.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.example.mytelkomselrefactoredapp.core.R

/**
 * Created by Rahmad Satria Kurniawan on 12/8/2022.
 * PT.Phincon
 * rahmad.kurniawan@phincon.com
 */

abstract class BaseActivity<VB : ViewBinding,ViewModel: BaseViewModel> : AppCompatActivity() {


    protected lateinit var binding: VB
    protected abstract val viewModel: ViewModel


    abstract fun getViewBinding(): VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding()
        setContentView(binding.root)
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