package com.example.mytelkomselrefactoredapp.presentation.utils

interface LiveDataModel

/**
 * Created by Rahmad Satria Kurniawan on 12/8/2022.
 * PT.Phincon
 * rahmad.kurniawan@phincon.com
 */

open class  LiveDataAwareModel: LiveDataModel{
    var isRedeliverd: Boolean = false
}