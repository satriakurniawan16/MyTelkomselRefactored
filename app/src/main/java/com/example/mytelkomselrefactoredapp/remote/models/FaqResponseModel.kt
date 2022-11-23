package com.example.mytelkomselrefactoredapp.remote.models

import com.squareup.moshi.Json

data class FaqResponseModel(
    @field:Json(name = "id")
    val id: LangId,
    @field:Json(name = "en")
    val en: LangEn
)