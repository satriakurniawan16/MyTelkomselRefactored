package com.example.mytelkomselrefactoredapp.data.mapper

import com.example.mytelkomselrefactoredapp.data.models.ContentEntity
import com.example.mytelkomselrefactoredapp.domain.models.Content
import javax.inject.Inject

class FaqEntityMapper @Inject constructor(private val contentMapper: ContentMapper) : Mapper<ContentEntity,Content> {
    override fun mapFromEntity(type: ContentEntity): Content {
        return Content(
            id = type.id,
            title = type.title
        )
    }

    override fun mapToEntity(type: Content): ContentEntity {
        return ContentEntity(
            id = type.id,
            title = type.title,
        )
    }
}