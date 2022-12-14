package com.example.mytelkomselrefactoredapp.data.models

import com.example.mytelkomselrefactoredapp.domain.models.Content
import com.example.mytelkomselrefactoredapp.domain.models.Topic

data class LangEnEntity(
    val content: List<ContentEntity>,
    val topic: List<TopicEntity>
)
