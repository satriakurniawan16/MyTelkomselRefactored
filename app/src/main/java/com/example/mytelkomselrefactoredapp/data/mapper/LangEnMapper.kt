package com.example.mytelkomselrefactoredapp.data.mapper

import com.example.mytelkomselrefactoredapp.core.model.Mapper
import com.example.mytelkomselrefactoredapp.data.models.LangEnEntity
import com.example.mytelkomselrefactoredapp.domain.models.LangEn
import javax.inject.Inject

class LangEnMapper @Inject constructor(private val contentMapper: ContentMapper,private val topicMapper: TopicMapper):
    Mapper<LangEnEntity, LangEn> {
    override fun mapFromEntity(type: LangEnEntity): LangEn {
        return LangEn(
            content = type.content.map { it -> contentMapper.mapFromEntity(it) },
            topic = type.topic.map{it -> topicMapper.mapFromEntity(it)}
        )
    }

    override fun mapToEntity(type: LangEn): LangEnEntity {
        return LangEnEntity(
            content = type.content.map { contentMapper.mapToEntity(it) },
            topic = type.topic.map { topicMapper.mapToEntity(it) }
        )
    }
}