package com.example.mytelkomselrefactoredapp.domain.interactor

import com.example.mytelkomselrefactoredapp.core.base.BaseUseCase
import com.example.mytelkomselrefactoredapp.domain.repository.WCMSRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


typealias GetAllTranslationBaseUseCase = BaseUseCase<Unit, Flow<String>>

class GetAllTranslationUseCase @Inject constructor(
    private val translationRepository: WCMSRepository
) : GetAllTranslationBaseUseCase {
    override suspend operator fun invoke(params: Unit) = translationRepository.getAllTranslation()
}