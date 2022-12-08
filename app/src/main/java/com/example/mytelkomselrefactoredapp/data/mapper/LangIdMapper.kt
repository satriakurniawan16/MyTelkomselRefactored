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
            content = type.content.map {  contentMapper.mapFromEntity(it)},
            topic = type.topic.map {topicMapper.mapFromEntity(it)}
        )
    }

    override fun mapToEntity(type: LangId): LangIdEntity {
        return LangIdEntity(
            content = type.content.map { contentMapper.mapToEntity(it)},
            topic = type.topic.map { topicMapper.mapToEntity(it) }
        )
    }

}