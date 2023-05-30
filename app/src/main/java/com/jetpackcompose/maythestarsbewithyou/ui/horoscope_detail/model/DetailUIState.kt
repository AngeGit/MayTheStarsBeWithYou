package com.jetpackcompose.maythestarsbewithyou.ui.horoscope_detail.model

import com.jetpackcompose.maythestarsbewithyou.data.network.model.HoroscopeResponse

sealed class DetailUIState{
    object Loading:DetailUIState()
    data class Success (val horoscopeResponse: HoroscopeResponse): DetailUIState()
    data class Error (val msg:String): DetailUIState()
}
