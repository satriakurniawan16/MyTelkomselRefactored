package com.example.mytelkomselrefactoredapp.remote.models

import com.squareup.moshi.Json

data class LangId(
    @field:Json(name = "content")
    val content: List<Content>,
    @field:Json(name = "topic")
    val topic: List<Topic>
)
