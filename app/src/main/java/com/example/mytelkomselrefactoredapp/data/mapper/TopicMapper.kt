package com.example.mytelkomselrefactoredapp.data.mapper

import com.example.mytelkomselrefactoredapp.core.model.Mapper
import com.example.mytelkomselrefactoredapp.data.models.TopicEntity
import com.example.mytelkomselrefactoredapp.domain.models.Topic
import javax.inject.Inject

class TopicMapper @Inject constructor(): Mapper<TopicEntity, Topic> {
    //    override fun mapFromEntity(type: List<TopicEntity>): List<Topic> {
//        var list: ArrayList<Topic> = arrayListOf()
//        type.forEachIndexed { index, topicEntity ->
//            list[index] = Topic(topicEntity.id,topicEntity.title)
//        }
//        return  list.toList()
//    }
//
//    override fun mapToEntity(type: List<Topic>): List<TopicEntity> {
//        var list: ArrayList<TopicEntity> = arrayListOf()
//        type.forEachIndexed { index, topic ->
//            list[index] = TopicEntity(topic.id,topic.title)
//        }
//        return  list.toList()
//    }
    override fun mapFromEntity(type: TopicEntity): Topic {
        return Topic(id = type.id, title = type.title)
    }

    override fun mapToEntity(type: Topic): TopicEntity {
        return TopicEntity(id = type.id, title = type.title)
    }

}