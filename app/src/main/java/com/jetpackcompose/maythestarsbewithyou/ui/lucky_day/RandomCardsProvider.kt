package com.jetpackcompose.maythestarsbewithyou.ui.lucky_day

import com.jetpackcompose.maythestarsbewithyou.R
import com.jetpackcompose.maythestarsbewithyou.ui.lucky_day.model.LuckyOfTheDayUIModel
import javax.inject.Inject
import kotlin.random.Random

class RandomCardsProvider @Inject constructor(){
     fun getLuckyCard():LuckyOfTheDayUIModel = when (Random.nextInt(0, 33)) {
         0 -> LuckyOfTheDayUIModel(R.drawable.card0, R.string.card0)
         1 -> LuckyOfTheDayUIModel(R.drawable.card1, R.string.card1)
         2 -> LuckyOfTheDayUIModel(R.drawable.card2, R.string.card2)
         3 -> LuckyOfTheDayUIModel(R.drawable.card3, R.string.card3)
         4 -> LuckyOfTheDayUIModel(R.drawable.card4, R.string.card4) //Falta el emperor XD Tengo TOC jajaja
         5 -> LuckyOfTheDayUIModel(R.drawable.card5, R.string.card5)
         6 -> LuckyOfTheDayUIModel(R.drawable.card6, R.string.card6)
         7 -> LuckyOfTheDayUIModel(R.drawable.card7, R.string.card7)
         8 -> LuckyOfTheDayUIModel(R.drawable.card8, R.string.card8)
         9 -> LuckyOfTheDayUIModel(R.drawable.card9, R.string.card9)
         10 -> LuckyOfTheDayUIModel(R.drawable.card10, R.string.card10)
         11 -> LuckyOfTheDayUIModel(R.drawable.card11, R.string.card11)
         12 -> LuckyOfTheDayUIModel(R.drawable.card12, R.string.card12)// falta el hanged man
         13 -> LuckyOfTheDayUIModel(R.drawable.card13, R.string.card13)
         14 -> LuckyOfTheDayUIModel(R.drawable.card14, R.string.card14)
         15 -> LuckyOfTheDayUIModel(R.drawable.card15, R.string.card15)
         16 -> LuckyOfTheDayUIModel(R.drawable.card16, R.string.card16)
         17 -> LuckyOfTheDayUIModel(R.drawable.card17, R.string.card17)
         18 -> LuckyOfTheDayUIModel(R.drawable.card18, R.string.card18)
         19 -> LuckyOfTheDayUIModel(R.drawable.card19, R.string.card19)
         20 -> LuckyOfTheDayUIModel(R.drawable.card20, R.string.card20)
         21 -> LuckyOfTheDayUIModel(R.drawable.card21, R.string.card21)
         22 -> LuckyOfTheDayUIModel(R.drawable.card22, R.string.card22)
         23 -> LuckyOfTheDayUIModel(R.drawable.card23, R.string.card23)
         24 -> LuckyOfTheDayUIModel(R.drawable.card24, R.string.card24)
         25 -> LuckyOfTheDayUIModel(R.drawable.card25, R.string.card25)
         26 -> LuckyOfTheDayUIModel(R.drawable.card26, R.string.card26)
         27 -> LuckyOfTheDayUIModel(R.drawable.card27, R.string.card27)
         28 -> LuckyOfTheDayUIModel(R.drawable.card28, R.string.card28)
         29 -> LuckyOfTheDayUIModel(R.drawable.card29, R.string.card29)
         30 -> LuckyOfTheDayUIModel(R.drawable.card30, R.string.card30)
         31 -> LuckyOfTheDayUIModel(R.drawable.card31, R.string.card31)
         32 -> LuckyOfTheDayUIModel(R.drawable.card32, R.string.card32)
         else -> LuckyOfTheDayUIModel(R.drawable.card_reverse, R.string.card_reverse)
     }



}