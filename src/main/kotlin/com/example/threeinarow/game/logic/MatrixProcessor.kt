package com.example.threeinarow.game.logic

import com.example.threeinarow.gameFieldObjects.jewel.Jewel
import com.example.threeinarow.gameFieldObjects.jewel.special.Bomb
import com.example.threeinarow.gameFieldObjects.jewel.special.HorizontalLineDestroyer
import com.example.threeinarow.gameFieldObjects.jewel.special.SameColorDestroyer
import com.example.threeinarow.gameFieldObjects.jewel.special.SpecialJewel
import com.example.threeinarow.gameFieldObjects.jewel.special.VerticalLineDestroyer


class MatrixProcessor(private var arr: Array<Array<Jewel?>>) : InterfaceMatrixProcessor {

//    public comboCounter: Int = 0


    ////////////////////////////////////////////////////////////////////////////
    override fun swapTwoJewels(firstJewel :Pair<Int, Int>, secondJewel :Pair<Int, Int>) {
        val i1 = firstJewel.first
        val j1 = firstJewel.second
        val i2 = secondJewel.first
        val j2 = secondJewel.second

        arr[i1][j1] = arr [i2][j2].also { arr[i2][j2] = arr [i1][j1] }


        // ЕСЛИ МЕНЯЮТСЯ МЕСТАМИ ДВА СПЕЦИАЛЬНЫХ, ТО ДОЛЖНА БЫТЬ ИХ ОСОБЕННАЯ АКТИВАЦИЯ, потом падение вниз
//        fullScan()
    }



    override fun fullScan() {
        //1)Меняю камни местами
        // НАДО ЕЩЁ ВЫЗВАТЬ ФУНКЦИЮ РИСОВАНИЯ ДЛЯ ЭТОГО ДЕЙСТВИЯ

        //2)Функ. Проверки по вертикали и горизонтали. Выставление где надо activate = true
        scanRows()
        scanColumns()
        // Надо чтоб они меняли счётчик комбо и возвращали булевское значение, отработали они или нет
        // ЕСЛИ КРУГОМ ФОЛС, ТО ОТРИСОВАТЬ ПЕРВЫЙ ПУНКТ ВСПЯТЬ, А ИНАЧЕ:

        //3) Отрисовка


        //4)Потом сканирую на наличие null значения,
        //если оно есть, то вызываю функ. Опускания и создания рандомных, и отрисовку

        activateSpecialJewels()
        //5) Срабатывание бомбы
    }





    override fun containsNull():Boolean { //+++++++++++++++++++++++++++++++++++++++
        for (i in arr.indices) {
            for (j in arr[0].indices) {
                if (arr[i][j]==null) {
                    return true
                }
            }
        }
        return false
    }

    override fun activateSpecialJewels() {
        TODO("Not yet implemented")
    }

    override fun fallDown() {
        TODO("Not yet implemented")
    }

    override fun randomJewelGeneration() {
        TODO("Not yet implemented")
    }

    override fun scanColumns() {
        for (j in arr[0].indices) {         //////////////+++++
            var color1 = arr[0][j]                //////////////+++++
            var count = 1

            for (i in 1 until arr.size) {                   //////////////+++++
                val color2 = arr[i][j]

                //если камень такой же, то идём дальше
                if (color1 == color2) {
                    count++

                    //если дошли до конца строки, то делаем проверку
                    if (i == arr.size - 1) {                         //////////////+++++
                        val startPoint = Pair(i - count + 1, j )
                        howManyInColumn(count, startPoint)
                    }
                }

                // если цвета разные
                else {
                    //делаем проверку
                    val startPoint = Pair(i - count, j )
                    howManyInColumn(count, startPoint)

                    // запоминаем новый цвет
                    color1 = arr[i][j]
                    count = 1
                }
            }
        }

    printMatrix()
    }

    private fun howManyInColumn(count: Int, startPoint: Pair<Int, Int>) {
        when (count) {
            5 -> fiveInARowVertically(startPoint)
            4 -> fourInARowVertically(startPoint)
            3 -> threeInARowVertically(startPoint)
        }
    }

    private fun threeInARowVertically(startPoint: Pair<Int, Int>) {
        var i = startPoint.first
        val j = startPoint.second
        repeat(3) {
            deleteJevelOrWhatever(i,j)
            i++
        }
    }

    private fun fourInARowVertically(startPoint: Pair<Int, Int>) {
        val i = startPoint.first
        val j = startPoint.second

        deleteJevelOrWhatever(i,j)
        deleteJevelOrWhatever(i+1,j, HorizontalLineDestroyer(arr[i+2][j]!!.color))
        deleteJevelOrWhatever(i+2,j)
        deleteJevelOrWhatever(i+3,j)

    }

    private fun fiveInARowVertically(startPoint: Pair<Int, Int>){
        val i = startPoint.first
        val j = startPoint.second

        deleteJevelOrWhatever(i,j)
        deleteJevelOrWhatever(i+1,j)
        deleteJevelOrWhatever(i+2,j, SameColorDestroyer(arr[i+3][j]!!.color))
        deleteJevelOrWhatever(i+3,j)
        deleteJevelOrWhatever(i+4,j)
    }

    override fun scanRows() {

    for (i in arr.indices) {
        var color1 = arr[i][0]
        var count = 1
        //на каждой новой строке задаём начальный цвет
        // и ставим счётчик на 1

        for (j in 1 until arr[0].size) {
            val color2 = arr[i][j]

            //если камень такой же, то идём дальше
            if (color1 == color2) {
                count++

                //если дошли до конца строки, то делаем проверку
                if (j==arr[0].size-1) {
                    val startPoint = Pair(i, j-count+1)
                    howManyInRow(count, startPoint)
                }
            }

            // если цвета разные
            else {
                //делаем проверку
                val startPoint = Pair(i, j-count)
                howManyInRow(count, startPoint)

                // запоминаем новый цвет
                color1 = arr[i][j]
                count = 1
            }
        }
    }
        printMatrix()
}

    private fun howManyInRow(count: Int, startPoint: Pair<Int, Int>) {
        when (count) {
            5 -> fiveInARowHorizontally(startPoint)
            4 -> fourInARowHorizontally(startPoint)
            3 -> if (createBomb(startPoint) == false) {
                threeInARowHorizontally(startPoint)
            }
        }
    }

    private fun printMatrix() {
        for (i in arr.indices) {
            for (j in arr[0].indices) {
                if (arr[i][j] == null) print("null ") else print(" ${arr[i][j]!!.color}   ")
            }
            println()
        }
    }


    private fun createBomb(startPoint: Pair<Int, Int>): Boolean {
        val i = startPoint.first
        val j = startPoint.second

        //startPoint ЭТО ЖЕ ЛЕВЫЙ ВЕРХНИЙ УГОЛ??

        return checkForBombFunc(i, j,     i+1, i+2, j) ||
                checkForBombFunc(i, j,    i-1, i-2, j) ||
                checkForBombFunc(i, j,   i+1, i+2, j+2) ||
                checkForBombFunc(i, j,   i-1, i-2, j+2)
    }

    private fun checkForBombFunc(i:Int, j:Int, i1:Int, i2:Int, j12:Int,): Boolean{
        val startPointJewel = arr[i][j]!!

        if (i2 > arr.size-1 || i2 < 0) return false
        // ПРОВЕРКА НА ВІХОД ЗА ГРАНИЦЫ МАТРИЦЫ

        if (startPointJewel ==arr[i1][j12] && startPointJewel ==arr[i2][j12]) {
            val color = startPointJewel.color

            threeInARowHorizontally(Pair(i,j))

            deleteJevelOrWhatever(i1, j12)
            deleteJevelOrWhatever(i2, j12)

            arr[i][j] = Bomb(color)
//            printMatrix()
            return true
        } else return false
    }


    private fun deleteJevelOrWhatever(i:Int, j:Int, whatToPutHere: Jewel? = null) {
        if (arr[i][j] is SpecialJewel) {
            (arr[i][j] as SpecialJewel).isActivated = true
        } else arr[i][j] = whatToPutHere

    }

    private fun threeInARowHorizontally(startPoint: Pair<Int, Int>) {
        val i = startPoint.first
        var j = startPoint.second
        repeat(3) {
            deleteJevelOrWhatever(i,j)
            j++
        }
    }
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


    private fun fourInARowHorizontally(startPoint: Pair<Int, Int>) {
        val i = startPoint.first
        val j = startPoint.second

        deleteJevelOrWhatever(i,j)
        deleteJevelOrWhatever(i,j+1, VerticalLineDestroyer(arr[i][j+2]!!.color))
        deleteJevelOrWhatever(i,j+2)
        deleteJevelOrWhatever(i,j+3)

    }
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    private fun fiveInARowHorizontally(startPoint: Pair<Int, Int>){
        val i = startPoint.first
        val j = startPoint.second

        deleteJevelOrWhatever(i,j)
        deleteJevelOrWhatever(i,j+1)
        deleteJevelOrWhatever(i,j+2, SameColorDestroyer(arr[i+3][j]!!.color))
        deleteJevelOrWhatever(i,j+3)
        deleteJevelOrWhatever(i,j+4)
    }
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++



    //Будут елементы, чтоб сломать которые нужно несколько раз возле них ломать камни:
    //
    //Дальше каждый лёд проверяет есть ли возле него null, если да,
    // то урон засчитал и дьду списано единицу прочности и его текстура становится более покоцанной
}