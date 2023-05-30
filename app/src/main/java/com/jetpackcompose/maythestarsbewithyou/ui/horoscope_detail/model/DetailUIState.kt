package com.jetpackcompose.maythestarsbewithyou.ui.horoscope_detail.model

import com.jetpackcompose.maythestarsbewithyou.domain.model.HoroscopeModel

sealed class DetailUIState {
    object Loading : DetailUIState()
    data class Success(val horoscopeModel: HoroscopeModel) : DetailUIState()
    data class Error(val msg: String) : DetailUIState()
}
