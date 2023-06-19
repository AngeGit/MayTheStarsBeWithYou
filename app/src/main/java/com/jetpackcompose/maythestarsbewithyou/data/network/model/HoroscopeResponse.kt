package com.jetpackcompose.maythestarsbewithyou.data.network.model

import com.google.gson.annotations.SerializedName
import com.jetpackcompose.maythestarsbewithyou.domain.model.HoroscopeModel

data class HoroscopeResponse(
    @SerializedName("date") val date: String,
    @SerializedName("horoscope") val horoscope: String,
    @SerializedName("icon") val icon: String,
    @SerializedName("id") val id: Int,
    @SerializedName("sign") val sign: String
)
    fun HoroscopeResponse.toDomain()=
        HoroscopeModel(
            horoscope = this.horoscope,
            sign = this.sign,
            icon = this.icon
        )

