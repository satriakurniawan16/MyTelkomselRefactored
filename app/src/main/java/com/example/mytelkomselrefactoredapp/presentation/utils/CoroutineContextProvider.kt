package com.example.mytelkomselrefactoredapp.presentation.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

/**
 * Created by Rahmad Satria Kurniawan on 12/8/2022.
 * PT.Phincon
 * rahmad.kurniawan@phincon.com
 */

interface CoroutineContextProvider {
    val io: CoroutineDispatcher
    val default: CoroutineDispatcher
    val main: CoroutineDispatcher
}

class CoroutineContextProviderImp @Inject constructor(
): CoroutineContextProvider{
    override val io = Dispatchers.IO
    override val default = Dispatchers.Default
    override val main: CoroutineDispatcher = Dispatchers.Main
}