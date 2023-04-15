package com.example.threeinarow.gameField.logic

import com.example.threeinarow.gameField.GameField
import com.example.threeinarow.view.GameView

class MouseProcessor(val gameField: GameField, val view: GameView): InterfaceMouseProcessor{

    var clickCount: Int = 0

    var jewel1ij = Pair(0, 0)
    var jewel2ij = Pair(0, 0)

    override fun process(x:Double, y:Double) {
        when(clickCount) {
            0 -> if (! isBeyondGameField(x,y)) {
                jewel1ij = identifyJewel(x,y)
            }
            1 -> if (! isBeyondGameField(x,y)) {
                jewel2ij = identifyJewel(x,y)
                if (checkNeighbours()==true) {
                    //// вызвать сравнение двух камней
                }
            }
        }

    }
    override fun isBeyondGameField(x: Double, y: Double): Boolean {
        ////ПРОВЕРКА НЕ ВЫХОДИТ ЛИ НАЖАТИЕ ЗА ОТРИСОВАННОЕ ИГРОВОЕ ПОЛЕ
        val jewelSize =  view.jewelPixelSize
        return !(x/jewelSize < gameField.horizontalSize && y/jewelSize < gameField.verticalSize)
    }

    override fun identifyJewel(x: Double, y: Double): Pair<Int, Int> {

        TODO("Not yet implemented")
        clickCount++
    }

    override fun checkNeighbours(): Boolean {
        TODO("Not yet implemented")
        /// проверка
        //jewel1: Pair<Int, Int>, jewel2: Pair<Int, Int>
        clickCount = 0
    }





}