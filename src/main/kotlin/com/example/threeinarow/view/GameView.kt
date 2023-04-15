package com.example.threeinarow.view

import com.example.threeinarow.gameField.GameField
import javafx.scene.canvas.Canvas
import javafx.scene.image.Image
import javafx.scene.paint.Color.WHITESMOKE
import kotlin.math.min


class GameView(val game: GameField, val canvas: Canvas): InterfaceGameView {

     var jewelPixelSize = 0.0
    override fun draw() {
        clear()

        drawGameField()
    }

    override fun drawGameField() {
        val arr = game.jewelArray
        val gc = canvas.graphicsContext2D

        val imageWidth = canvas.width/game.horizontalSize
        val imageHeight = canvas.height/game.verticalSize

        jewelPixelSize = min(imageWidth, imageHeight)

        for (i in arr.indices) {
            for (j in arr[0].indices) {
                gc.drawImage(Image(arr[i][j].texture),
                    j*jewelPixelSize, i*jewelPixelSize, jewelPixelSize, jewelPixelSize)

            }
        }

    }

    override fun drawOneJewel() {

    }

    override fun highlightJewel() {
        TODO("Not yet implemented")
    }

    override fun drawScore() {
        TODO("Not yet implemented")
    }

    override fun drawTimeLeft() {
        TODO("Not yet implemented")
    }

    override fun clear() {
        val gc = canvas.graphicsContext2D
        gc.fill = WHITESMOKE
        gc.fillRect(0.0, 0.0, canvas.width, canvas.height)
    }
}