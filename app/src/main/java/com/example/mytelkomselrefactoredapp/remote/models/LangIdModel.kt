package com.example.mytelkomselrefactoredapp.remote.models

import com.squareup.moshi.Json

data class LangIdModel(
    @field:Json(name = "content")
    val content: List<ContentModel>,
    @field:Json(name = "topic")
    val topic: List<TopicModel>
)
