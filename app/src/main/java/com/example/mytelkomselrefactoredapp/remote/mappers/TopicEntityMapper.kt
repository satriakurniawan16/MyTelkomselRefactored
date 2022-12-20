package com.example.mytelkomselrefactoredapp.remote.mappers

import com.example.mytelkomselrefactoredapp.core.model.EntityMapper
import com.example.mytelkomselrefactoredapp.data.models.TopicEntity
import com.example.mytelkomselrefactoredapp.remote.models.TopicModel
import javax.inject.Inject

class TopicEntityMapper @Inject constructor(): EntityMapper<TopicModel, TopicEntity> {
    override fun mapFromModel(model: TopicModel): TopicEntity {
        return TopicEntity(id = model.id, title = model.title )
    }
}