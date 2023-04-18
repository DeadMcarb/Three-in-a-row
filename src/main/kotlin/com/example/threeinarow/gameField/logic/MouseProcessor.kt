package com.example.threeinarow.gameField.logic

import com.example.threeinarow.gameField.GameField
import com.example.threeinarow.view.GameView
import kotlin.math.abs
import kotlin.math.floor

class MouseProcessor(val gameField: GameField, val view: GameView): InterfaceMouseProcessor{

    private var clickCount: Int = 0

    private var jewel1ij = Pair(0, 0)
    private var jewel2ij = Pair(0, 0)

    override fun process(x:Double, y:Double) {
        ///////////////////
//        println(isBeyondGameField(x,y))
        ///////////////////
        when(clickCount) {
            0 -> if (! isBeyondGameField(x,y)) {
                jewel1ij = identifyJewel(x,y)
//                view.highlightJewel(jewel1ij)
            }
            1 -> if (! isBeyondGameField(x,y)) {
                val secondJewel = identifyJewel(x,y)

                if (isSameJewel(secondJewel)) {
                    jewel2ij = secondJewel

                    if (checkNeighbours()==true) {
                        //// вызвать обмен двух камней
                    }
                }
            }
        }


//        println(clickCount)
//        when(clickCount) {
//            0 -> if (! isBeyondGameField(x,y)) {
//
//                println(identifyJewel(x,y))
//            }
//            1 -> if (! isBeyondGameField(x,y)) {
//
//                println(identifyJewel(x,y))
//                println(checkNeighbours())
//            }
//        }

    }

    fun isSameJewel (secondJewel: Pair<Int, Int>): Boolean {
        return (jewel1ij.first == secondJewel.first
                && jewel1ij.second == secondJewel.second)
    }

    override fun isBeyondGameField(x: Double, y: Double): Boolean {
        ////ПРОВЕРКА НЕ ВЫХОДИТ ЛИ НАЖАТИЕ ЗА ОТРИСОВАННОЕ ИГРОВОЕ ПОЛЕ
        val jewelSize =  view.jewelPixelSize
        return !(x/jewelSize < gameField.horizontalSize && y/jewelSize < gameField.verticalSize)
    }

    override fun identifyJewel(x: Double, y: Double): Pair<Int, Int> {
        clickCount++

        val jewelSize =  view.jewelPixelSize
        val j = floor(x/jewelSize).toInt()
        val i =floor(y/jewelSize).toInt()

        return Pair(i, j)
    }

    override fun checkNeighbours(): Boolean {
        clickCount = 0

        return (abs(jewel1ij.first - jewel2ij.first) <= 1
                && abs(jewel1ij.second - jewel2ij.second) <= 1)
    }

}