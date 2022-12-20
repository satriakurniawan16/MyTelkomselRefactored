package com.example.mytelkomselrefactoredapp.domain.interactor

import com.example.mytelkomselrefactoredapp.core.base.BaseUseCase
import com.example.mytelkomselrefactoredapp.domain.models.Faq
import com.example.mytelkomselrefactoredapp.domain.repository.WCMSRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


typealias GetFaqBaseUseCase = BaseUseCase<Unit, Flow<Faq>>
class GetFaqUseCase @Inject constructor(private val wcmsRepository: WCMSRepository) : GetFaqBaseUseCase{
    override suspend operator fun invoke(params: Unit): Flow<Faq> = wcmsRepository.getFaq()

}