package com.example.mytelkomselrefactoredapp.util

import androidx.annotation.StringRes

/**
 * Created by Rahmad Satria Kurniawan on 12/8/2022.
 * PT.Phincon
 * rahmad.kurniawan@phincon.com
 */

internal object ExceptionHandler {

    @StringRes
    fun parse(t: Throwable): Int {
        return 0 /*when (t) {
            is UnknownHostException -> R.string.error_check_internet_connection
            else -> R.string.error_oops_error_occured
        }*/
    }
}