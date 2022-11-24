package com.example.mytelkomselrefactoredapp.data.mapper

import com.example.mytelkomselrefactoredapp.data.models.FaqEntity
import com.example.mytelkomselrefactoredapp.domain.models.Faq
import javax.inject.Inject

class FaqEntityMapper @Inject constructor(private val langIdMapper: LangIdMapper,private val langEnMapper: LangEnMapper) : Mapper<FaqEntity,Faq> {
    override fun mapFromEntity(type: FaqEntity): Faq {
        return Faq(
            id = langIdMapper.mapFromEntity(type.id),
            en = langEnMapper.mapFromEntity(type.en)
        )
    }

    override fun mapToEntity(type: Faq): FaqEntity {
        return FaqEntity(
            id = langIdMapper.mapToEntity(type.id),
            en = langEnMapper.mapToEntity(type.en)
        )
    }

}