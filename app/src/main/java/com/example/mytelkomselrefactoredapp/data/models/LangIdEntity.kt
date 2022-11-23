package com.example.mytelkomselrefactoredapp.data.models

import com.example.mytelkomselrefactoredapp.domain.models.Content
import com.example.mytelkomselrefactoredapp.domain.models.Topic

data class LangIdEntity(
    val content: ContentEntity,
    val topic: TopicEntity
)
