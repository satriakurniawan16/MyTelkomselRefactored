package com.example.mytelkomselrefactoredapp.remote.mappers

import com.example.mytelkomselrefactoredapp.data.models.ContentEntity
import com.example.mytelkomselrefactoredapp.remote.models.ContentModel
import javax.inject.Inject

class ContentEntityMapper @Inject constructor(): EntityMapper<ContentModel,ContentEntity> {
    override fun mapFromModel(model: ContentModel): ContentEntity {
        return ContentEntity(id = model.id, title = model.title)
    }
}