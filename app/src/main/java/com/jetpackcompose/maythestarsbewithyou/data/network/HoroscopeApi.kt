package com.jetpackcompose.maythestarsbewithyou.data.network

import com.jetpackcompose.maythestarsbewithyou.data.network.model.HoroscopeResponse
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Query

interface HoroscopeApi {
    // POST: https://aztro.sameerkumar.website?sign= <sign> &day= <day>
    //Si ponemos la ruta vacía, crashea
    @POST(".")
    suspend fun getHoroscope(
        @Query("sign") sign:String,
        @Query("day") day:String
        ):Response<HoroscopeResponse>
}