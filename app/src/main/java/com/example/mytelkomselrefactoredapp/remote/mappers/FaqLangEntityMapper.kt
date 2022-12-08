package com.example.mytelkomselrefactoredapp.remote.mappers

import com.example.mytelkomselrefactoredapp.data.models.LangEnEntity
import com.example.mytelkomselrefactoredapp.remote.models.LangEnModel
import com.example.mytelkomselrefactoredapp.remote.models.LangIdModel
import javax.inject.Inject

class FaqLangEntityMapper @Inject constructor(private val contentEntityMapper: ContentEntityMapper,private val topicEntityMapper: TopicEntityMapper): EntityMapper<LangEnModel,LangEnEntity> {
    override fun mapFromModel(model: LangEnModel): LangEnEntity {
        return LangEnEntity(
            content = model.content.map { it -> contentEntityMapper.mapFromModel(it)},
            topic = model.topic.map {topicEntityMapper.mapFromModel(it) }
        )
    }

}