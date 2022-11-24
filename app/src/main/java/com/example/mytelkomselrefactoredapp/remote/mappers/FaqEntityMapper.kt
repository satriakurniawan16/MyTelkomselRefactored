package com.example.mytelkomselrefactoredapp.remote.mappers

import com.example.mytelkomselrefactoredapp.data.models.FaqEntity
import com.example.mytelkomselrefactoredapp.remote.models.FaqResponseModel
import javax.inject.Inject

class FaqEntityMapper @Inject constructor (private val langEntityMapper: FaqLangEntityMapper,private val langIdEntityMapper: FaqLangIdEntityMapper):EntityMapper<FaqResponseModel,FaqEntity>{
    override fun mapFromModel(model: FaqResponseModel): FaqEntity {
        return FaqEntity(
            id = langEntityMapper,
            en =
        )
    }
}