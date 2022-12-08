package com.example.mytelkomselrefactoredapp.remote.mappers

import com.example.mytelkomselrefactoredapp.data.models.LangIdEntity
import com.example.mytelkomselrefactoredapp.remote.models.LangIdModel
import javax.inject.Inject

class FaqLangIdEntityMapper @Inject constructor(private val contentEntityMapper: ContentEntityMapper,private val topicEntityMapper: TopicEntityMapper): EntityMapper<LangIdModel,LangIdEntity>{
    override fun mapFromModel(model: LangIdModel): LangIdEntity {
        return LangIdEntity(
            content = model.content.map { contentEntityMapper.mapFromModel(it) },
            topic =  model.topic.map { topicEntityMapper.mapFromModel(it) }
        )
    }
}