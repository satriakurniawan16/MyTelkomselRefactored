package com.example.mytelkomselrefactoredapp.data.mapper

import com.example.mytelkomselrefactoredapp.data.models.LangIdEntity
import com.example.mytelkomselrefactoredapp.domain.models.LangId
import javax.inject.Inject

class LangIdMapper @Inject constructor(
    private val contentMapper: ContentMapper,
    private val topicMapper: TopicMapper
) : Mapper<LangIdEntity, LangId> {
    override fun mapFromEntity(type: LangIdEntity): LangId {
        return LangId(
            content = contentMapper.mapFromEntity(type.content),
            topic = topicMapper.mapFromEntity(type = type.topic)
        )
    }

    override fun mapToEntity(type: LangId): LangIdEntity {
        return LangIdEntity(
            content = contentMapper.mapToEntity(type = type.content),
            topic = topicMapper.mapToEntity(type = type.topic)
        )
    }

}