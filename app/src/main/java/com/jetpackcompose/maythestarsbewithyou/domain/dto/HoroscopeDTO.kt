package com.jetpackcompose.maythestarsbewithyou.domain.dto

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

data class HoroscopeDTO(
    val sign: String,
    val date: String = getTodayDateFormatted(),
    val language:String = "es"

)
private fun getTodayDateFormatted(): String =
    SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())


