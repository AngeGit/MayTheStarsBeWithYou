package com.jetpackcompose.maythestarsbewithyou.ui.horoscope_list.backgoundanimationscreen


import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.delay
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit


@Composable
fun CreateMatrixChar(
    textSizeSp: TextUnit,
    char: String,
    crawlSpeed: Long,
    onFinished: () -> Unit
) {
    var textColor by remember{ mutableStateOf(Color(0xFFB796F1)) } //Color Inicial claro //0xffcefbe4
    var startFading by remember {mutableStateOf(false)} //A true cuando tiene que empezar a desvanecerse la letra
    val alpha by animateFloatAsState(
        targetValue = if (startFading) 0f else 1f,
        animationSpec = tween(
            durationMillis = 4000, // animation duration: desde que cambia de lila a que se desvanece
            easing = LinearEasing //  Curva de animación. Siempre la animación va al mismo ritmo
        ), //animation de verde a desaparecer
        finishedListener = { onFinished()} //lambda con lo que va a hacer al acabar
    )

    Text(
        text = char,
        fontSize = textSizeSp,
        fontWeight= FontWeight.ExtraBold,
        color = textColor.copy(alpha = alpha),

    )
    //Unit: que sólo se lance una vez en el ciclo de vida de este matrix char
    LaunchedEffect(Unit) {
        delay(crawlSpeed) //Velocidad a la que van cada una de las líneas
        textColor = Color(0xFF821DDB)
        //0xff43c728)
        startFading = true
    }

}


