package com.jetpackcompose.maythestarsbewithyou.data.network

import com.jetpackcompose.maythestarsbewithyou.core.network.ResultType
import com.jetpackcompose.maythestarsbewithyou.data.network.model.toDomain
import com.jetpackcompose.maythestarsbewithyou.domain.dto.HoroscopeDTO
import com.jetpackcompose.maythestarsbewithyou.domain.model.HoroscopeModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class HoroscopeRepository @Inject constructor(
    private val api: HoroscopeApi
) {
    fun getHoroscope(horoscopeDTO: HoroscopeDTO): Flow<ResultType<HoroscopeModel>> = flow {
        try {
            val response = api.getHoroscope(
                horoscopeDTO.sign,
                horoscopeDTO.date,
                horoscopeDTO.language
            )
            if (response.isSuccessful) {
                response.body()?.let { horoscopeResponse->
                    emit(ResultType.Success(horoscopeResponse.toDomain()))
                }

            } else {
                val msg = when(response.code()){
                    404->"NOT FOUND"
                    else -> "ERROR GENÉRICO"
                }
                emit(ResultType.Error(response.errorBody().toString()))
            }
        } catch (e: Exception) {
            emit(ResultType.Error(e.message))
        }

    }


}