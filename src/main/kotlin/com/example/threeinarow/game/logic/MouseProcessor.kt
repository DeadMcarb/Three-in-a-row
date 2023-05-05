package com.example.threeinarow.game.logic

import com.example.threeinarow.game.GameField
import com.example.threeinarow.view.GameFieldFieldView
import kotlin.math.abs
import kotlin.math.floor

////  КЛАСС ЗАКОЧЕН
class MouseProcessor(
    private val gameField: GameField,
    private val view: GameFieldFieldView,
    private val matrixProcessor: InterfaceMatrixProcessor
): InterfaceMouseProcessor{

    private var clickCount: Int = 0

    private var jewel1ij = Pair(0, 0)
    private var jewel2ij = Pair(0, 0)

    override fun process(x:Double, y:Double) {

        when(clickCount) {
            0 -> if (! isBeyondGameField(x,y)) {
                jewel1ij = identifyJewel(x,y)
                view.highlightJewel(jewel1ij)
            }
            1 -> if (! isBeyondGameField(x,y)) {
                val secondJewel = identifyJewel(x,y)

                if (! isSameJewel(secondJewel)) {
                    jewel2ij = secondJewel
                    view.highlightJewel(jewel2ij)


                    /// ПОЧЕМУ НА ЭТОМ КУСКЕ КОДА НЕ СРАБАТЫВАЕТ ВТОРАЯ ОБВОДКА??????????????????????????????????
                    if (checkNeighbours()==true) {
                        //// вызвать обмен двух камней
//                        Thread.sleep(500)
                        view.drawTwoJewels(jewel1ij, jewel2ij)
                        matrixProcessor.swapTwoJewels(jewel1ij, jewel2ij)
                        //// поменять их местами на рисунке
                    } else {
//                        Thread.sleep(500)  /// НОРМАЛЬНО ЛИ ПИСАТЬ ТАК ИЛИ МОЖНО ПАУЗУ ПО ДРУГОМУ????????????
                        view.drawTwoJewels(jewel1ij, jewel2ij)
                    }

                }
            }
        }

    }

    private fun isSameJewel (secondJewel: Pair<Int, Int>): Boolean {
        return (jewel1ij.first == secondJewel.first
                && jewel1ij.second == secondJewel.second)
    }

    override fun isBeyondGameField(x: Double, y: Double): Boolean {
        ////ПРОВЕРКА НЕ ВЫХОДИТ ЛИ НАЖАТИЕ ЗА ОТРИСОВАННОЕ ИГРОВОЕ ПОЛЕ
        val jewelSize =  view.jewelSizeInPixels
        return !(x/jewelSize < gameField.horizontalSize && y/jewelSize < gameField.verticalSize)
    }

    override fun identifyJewel(x: Double, y: Double): Pair<Int, Int> {
        clickCount++

        val jewelSize =  view.jewelSizeInPixels
        val j = floor(x/jewelSize).toInt()
        val i =floor(y/jewelSize).toInt()

        return Pair(i, j)
    }

    override fun checkNeighbours(): Boolean {
        clickCount = 0

        val condition1 = abs(jewel1ij.first - jewel2ij.first)
        val condition2 = abs(jewel1ij.second - jewel2ij.second)

        return (condition1 == 1 && condition2 == 0) || (condition1 == 0 && condition2 == 1)
    }

}