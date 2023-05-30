package com.jetpackcompose.maythestarsbewithyou.domain

import com.jetpackcompose.maythestarsbewithyou.core.network.ResultType
import com.jetpackcompose.maythestarsbewithyou.data.network.HoroscopeRepository
import com.jetpackcompose.maythestarsbewithyou.data.network.model.HoroscopeResponse
import com.jetpackcompose.maythestarsbewithyou.domain.dto.HoroscopeDTO
import com.jetpackcompose.maythestarsbewithyou.domain.model.HoroscopeModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetHoroscopeUseCase @Inject constructor(
    private val  repository: HoroscopeRepository
) {
    //A pesar de ser buenas prácticas, se está empezando a quitar el domain porque básicamente la lógica la tiene el repository
    operator fun invoke(horoscopeDTO: HoroscopeDTO): Flow<ResultType<HoroscopeModel>> = repository.getHoroscope(horoscopeDTO)

}
