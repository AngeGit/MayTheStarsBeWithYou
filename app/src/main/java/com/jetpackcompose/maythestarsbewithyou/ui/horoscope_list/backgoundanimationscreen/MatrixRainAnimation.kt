package com.jetpackcompose.maythestarsbewithyou.ui.horoscope_list.backgoundanimationscreen

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import kotlinx.coroutines.delay
import kotlin.random.Random

@Composable
fun MatrixRainAnimation(matrixRainAnimationVm: MatrixRainAnimationViewModel) {
    paintMatrixRow(matrixRainAnimationVm)
}

@Composable
fun paintMatrixRow(matrixRainAnimationVm: MatrixRainAnimationViewModel, stripCountColumns:Int=18){
    // yStartDelay= Lo que tarda en empezar a pintarse una nueva columna
    // crawlSpeed = Lo rápido que va la columna al bajar
    Row{
        repeat(stripCountColumns){
            paintMatrixColumn(
                matrixRainAnimationVm,
                (Random.nextInt(10)*10L)+50, //100?
                Random.nextInt(8) * 1000L)
        }
    }
}

@Composable
fun RowScope.paintMatrixColumn(matrixRainAnimationVm: MatrixRainAnimationViewModel, crawlSpeed:Long, yStartDelay:Long) {
    // Para adaptarnos al alto/ancho que tenemos, metemos la columna en un BoxWithConstrains,
    // que nos permite acceder a las medidas de la pantalla
    BoxWithConstraints(
        modifier = Modifier
            .weight(1f)
            .fillMaxHeight()
    ){
        val maxWidthDp = maxWidth
        //Hay que hacer que recuerde la columna, porque si no a cada vez que renderice, va a crear una nueva tira (matrixStrip)
        //Para calcular el num de cols que entran en la pantalla usamos maxHeight/Width
        val matrixStrip = remember {Array((maxHeight/maxWidth).toInt()){matrixRainAnimationVm.characters.random()} }
        //Para que no las pinte todas juntas, usamos un contador que activamos cuando empieza la animación
        var lettersToDraw by remember { mutableStateOf(0)}
        Column(modifier=Modifier.fillMaxSize()){
            repeat(lettersToDraw){
                //El fontsize va a ser el maxwidth pasado a sp:
                CreateMatrixChar(
                    textSizeSp = with(LocalDensity.current){maxWidthDp.toSp()},
                    char = matrixStrip[it] ,
                    crawlSpeed = crawlSpeed) {
                    if(it >= matrixStrip.size * 0.6){
                        lettersToDraw=0
                    }
                }
            }
        }
        LaunchedEffect(Unit){
            delay(yStartDelay)
            while(true){
                if(lettersToDraw<matrixStrip.size){
                    lettersToDraw +=1
                }
                if(lettersToDraw < matrixStrip.size * 0.5){ //Si ha llegado a pintar la mitad
                    matrixStrip[Random.nextInt(lettersToDraw)] = matrixRainAnimationVm.characters.random() //Cambiamos alguna de las que están pintadas por otro character
                }
                delay(crawlSpeed)
            }
        }
    }

}
