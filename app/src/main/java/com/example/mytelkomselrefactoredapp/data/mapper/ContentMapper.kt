package com.example.mytelkomselrefactoredapp.data.mapper

import com.example.mytelkomselrefactoredapp.core.model.Mapper
import com.example.mytelkomselrefactoredapp.data.models.ContentEntity
import com.example.mytelkomselrefactoredapp.domain.models.Content
import javax.inject.Inject

class ContentMapper @Inject constructor() : Mapper<ContentEntity, Content> {

    //    override fun mapFromEntity(type: List<ContentEntity>): List<Content> {
//        var list: ArrayList<Content> = arrayListOf()
//        type.forEachIndexed { index, contentEntity ->
//            list[index] = Content(contentEntity.id,contentEntity.title)
//        }
//        return  list.toList()
//    }
//
//    override fun mapToEntity(type: List<Content>): List<ContentEntity> {
//        var list: ArrayList<ContentEntity> = arrayListOf()
//        type.forEachIndexed { index, content ->
//            list[index] = ContentEntity(content.id,content.title)
//        }
//        return  list.toList()
//    }
    override fun mapFromEntity(type: ContentEntity): Content {
        return Content(id = type.id, title = type.title)
    }

    override fun mapToEntity(type: Content): ContentEntity {
        return ContentEntity(id = type.id, title = type.title)
    }
}