package com.example.threeinarow.view

import com.example.threeinarow.game.Game
import com.example.threeinarow.game.GameField
import com.example.threeinarow.gameFieldObjects.jewel.Jewel
import javafx.scene.canvas.Canvas
import javafx.scene.paint.Color.*
import kotlin.math.min


class GameFieldFieldView(val gameField: GameField, val canvas: Canvas): InterfaceGameFieldView {

     var jewelSizeInPixels = 0.0
    override fun draw() {
        clear()
        drawGameField()
    }

    override fun drawGameField() {
        val arr = gameField.jewelArray
//        val gc = canvas.graphicsContext2D

        val imageWidth = canvas.width/gameField.horizontalSize
        val imageHeight = canvas.height/gameField.verticalSize

        jewelSizeInPixels = min(imageWidth, imageHeight)

        for (i in arr.indices) {
            for (j in arr[0].indices) {
                drawOneJewel(i, j)
            }
        }

    }

    override fun drawOneJewel(i: Int, j: Int) {        //////????????????????????
        //// НОРМАЛЬНО ЛИ ЭТО КАЖДЫЙ РАЗ ДОСТАВАТЬ ГЦ????
        val gc = canvas.graphicsContext2D

        gc.drawImage(gameField.jewelArray[i][j].texture,
            j*jewelSizeInPixels, i*jewelSizeInPixels, jewelSizeInPixels, jewelSizeInPixels)
    }

    fun drawTwoJewels(jewel1ij: Pair<Int, Int>,jewel2ij: Pair<Int, Int>) {
        drawOneJewel(jewel1ij.first, jewel1ij.second)
        drawOneJewel(jewel2ij.first, jewel2ij.second)
    }

    override fun highlightJewel(jewelij: Pair<Int, Int>) {
        val gc = canvas.graphicsContext2D
        gc.stroke = PINK

        val lineWidth = jewelSizeInPixels*0.05

        gc.lineWidth = lineWidth
        gc.strokeRect(jewelij.second * jewelSizeInPixels + lineWidth/2,
            jewelij.first * jewelSizeInPixels + lineWidth/2,
            jewelSizeInPixels - lineWidth,
            jewelSizeInPixels - lineWidth)

//        println("highlighted")
    }



    override fun clear() {
        val gc = canvas.graphicsContext2D
        gc.fill = WHITESMOKE
        gc.fillRect(0.0, 0.0, canvas.width, canvas.height)
    }
}