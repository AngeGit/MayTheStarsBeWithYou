package com.jetpackcompose.maythestarsbewithyou.ui.lucky_day.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import kotlin.random.Random

data class LuckyOfTheDayUIModel(
    @DrawableRes var image:Int,
    @StringRes var cardName:Int,
    val isLuckyDay:Boolean = Random.nextBoolean(),
    val textAboutDay: String=""
)
