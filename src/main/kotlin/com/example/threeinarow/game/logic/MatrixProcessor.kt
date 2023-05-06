package com.example.threeinarow.game.logic

import com.example.threeinarow.game.Game
import com.example.threeinarow.gameFieldObjects.jewel.Colors
import com.example.threeinarow.gameFieldObjects.jewel.Jewel
import com.example.threeinarow.gameFieldObjects.jewel.SimpleJewel
import com.example.threeinarow.gameFieldObjects.jewel.special.Bomb
import com.example.threeinarow.gameFieldObjects.jewel.special.HorizontalLineDestroyer
import com.example.threeinarow.gameFieldObjects.jewel.special.SameColorDestroyer
import com.example.threeinarow.gameFieldObjects.jewel.special.SpecialJewel
import com.example.threeinarow.gameFieldObjects.jewel.special.VerticalLineDestroyer
import com.example.threeinarow.view.GameFieldFieldView
import com.example.threeinarow.view.LabelView.ScoreView


class MatrixProcessor(
    game: Game,
    private val fieldView: GameFieldFieldView,
    private val scoreView: ScoreView,
    )
    : InterfaceMatrixProcessor {
    private val arr: Array<Array<Jewel?>> = game.gameField.jewelArray
    private var score: Int = game.score
    private var comboCounter: Int = 0


    ////////////////////////////////////////////////////////////////////////////
    fun printMatrix() {
        for (i in arr.indices) {
            for (j in arr[0].indices) {
                if (arr[i][j] == null) print("null ") else {
                    when(arr[i][j]!!) {
                        is SimpleJewel -> {
                            print("  ${arr[i][j]!!.color}  ")
                        }

                        is VerticalLineDestroyer -> {
                            print("Vert ")
                        }

                        is HorizontalLineDestroyer -> {
                            print("Hori ")
                        }

                        is SameColorDestroyer -> {
                            print("Same ")
                        }

                        is Bomb -> {
                            print("Bomb ")
                        }
                    }
                }
            }
            println()
        }
        println("....................................")
    }

    override fun swapTwoJewels(firstJewel :Pair<Int, Int>, secondJewel :Pair<Int, Int>) {
        val i1 = firstJewel.first
        val j1 = firstJewel.second
        val i2 = secondJewel.first
        val j2 = secondJewel.second

        //поменять местами в матрице
        arr[i1][j1] = arr [i2][j2].also { arr[i2][j2] = arr [i1][j1] }
        //поменять местами на рисунке
        fieldView.drawTwoJewels(firstJewel, secondJewel)
//        Thread.sleep(5000)

        fullScan()
//        if (fullScan() == false) {
//            arr[i1][j1] = arr [i2][j2].also { arr[i2][j2] = arr [i1][j1] }
//            //поменять местами на рисунке
//            fieldView.drawTwoJewels(firstJewel, secondJewel)
//        }        // ЕСЛИ МЕНЯЮТСЯ МЕСТАМИ ДВА СПЕЦИАЛЬНЫХ, ТО ДОЛЖНА БЫТЬ ИХ ОСОБЕННАЯ АКТИВАЦИЯ, потом падение вниз
    }



    override fun fullScan() {

//        //2)Функ. Проверки по вертикали и горизонтали. Выставление где надо activate = true
//        ScanRowsAndColumns()
//        // Надо чтоб они меняли счётчик комбо
//
//        //3) Отрисовка
//        printMatrix()
//        fieldView.update()
////        if (comboCounter>0) {
////            fieldView.update()
////        }
//
//        //4)Потом сканирую на наличие null значения,
//        //если оно есть, то вызываю функ. Опускания и создания рандомных, и отрисовку
//        fallDown()
//        printMatrix()
//        fieldView.update()
////        activateSpecialJewels()
//        //5) Срабатывание бомбы



        comboCounter = -1

        while (comboCounter != 0 ) {
            comboCounter = 0
            ScanRowsAndColumns()
            printMatrix()
            fieldView.update()

            fallDown()
            printMatrix()
            fieldView.update()

            activateALLSpecialJewels()
            printMatrix()
            fieldView.update()

            fallDown()
            printMatrix()
            fieldView.update()
        }
    }



    fun ScanRowsAndColumns() {
        scanRows()
        scanColumns()
    }



//    override fun containsNull():Boolean { //+++++++++++++++++++++++++++++++++++++++
//        for (i in arr.indices) {
//            for (j in arr[0].indices) {
//                if (arr[i][j]==null) {
//                    return true
//                }
//            }
//        }
//        return false
//    }

    //    ++++++++++++++++++
    override fun activateALLSpecialJewels() {
        var activatedJewelsCount = -1

        while (activatedJewelsCount != 0) {
            activatedJewelsCount = 0
            for (i in arr.indices) {
                for (j in arr[0].indices) {
                    if (arr[i][j] is SpecialJewel) {
                        if (activateSpecialJewel (i, j)) activatedJewelsCount++
                    }
                }
            }
        }
    }

    //    ++++++++++++++++++
    fun activateSpecialJewel (i: Int, j: Int): Boolean {
        val element = arr[i][j]
        when (element) {
            is VerticalLineDestroyer -> {

                if (element.isActivated) {
                    //активатор удаляет стрелу или бомбу вручную
                    arr[i][j] = null
                    score += 10
                    scoreView.update()

                    for (e in arr.indices) {
                        deleteJevelOrWhatever(e, j)
                    }

                    return true
                }
            }

            is HorizontalLineDestroyer -> {

                if (element.isActivated) {

                    arr[i][j] = null
                    score += 10
                    scoreView.update()

                    for (e in arr[0].indices) {
                        deleteJevelOrWhatever(i, e)
                    }

                    return true
                }
            }

            is SameColorDestroyer -> {

                if (element.isActivated) {

                    arr[i][j] = null
                    score += 10
                    scoreView.update()

                    for (i1 in arr.indices) {
                        for (j1 in arr[0].indices) {
                            if (element.equals(arr[i1][j1])) {
                                deleteJevelOrWhatever (i1, j1)
                            }
                        }
                    }

                    return true
                }
            }

            is Bomb -> {

                if (element.isActivated) {

                    arr[i][j] = null
                    score += 10
                    scoreView.update()

                    // проверка четірёх диагоналей квадрата 3 на 3

                    // левый верхний
                    if (! isBombExplosionBehindGameField(i-1, j-1)) {
                        deleteJevelOrWhatever (i-1, j-1)
                        deleteJevelOrWhatever (i, j-1)
                        deleteJevelOrWhatever (i-1, j)
                    }
                    // правый нижний
                    if (! isBombExplosionBehindGameField(i+1, j+1)) {
                        deleteJevelOrWhatever (i+1, j+1)
                        deleteJevelOrWhatever (i, j+1)
                        deleteJevelOrWhatever (i+1, j)
                    }
                    // левый нижний
                    if (! isBombExplosionBehindGameField(i+1, j-1)) {
                        deleteJevelOrWhatever (i+1, j-1)
                        deleteJevelOrWhatever (i, j-1)
                        deleteJevelOrWhatever (i+1, j)
                    }
                    // правый верхний
                    if (! isBombExplosionBehindGameField(i-1, j+1)) {
                        deleteJevelOrWhatever (i-1, j+1)
                        deleteJevelOrWhatever (i, j+1)
                        deleteJevelOrWhatever (i-1, j)
                    }

                    return true
                }
            }
        }
        return false
    }


    private fun isBombExplosionBehindGameField(i1: Int, j1: Int): Boolean {
        return ((i1 > arr.size-1 || i1 < 0) || (j1 > arr.size-1 || j1 < 0))
    }



    private fun deleteJevelOrWhatever(i:Int, j:Int, whatToPutHere: Jewel? = null) {
        if (arr[i][j]!= null) {
            if (arr[i][j] is SpecialJewel) {
                (arr[i][j] as SpecialJewel).isActivated = true
            } else {
                arr[i][j] = whatToPutHere

                score += 10
                scoreView.update()
            }
        }
    }

    override fun fallDown() {
        for (j in arr[0].indices) {
            for (i in arr.indices.reversed()) {
                //если найдена пустота
                if (arr[i][j] == null) {

                    while (arr[i][j] == null) {
                        // опускание вниз по одному всех элементов, что были выше пустоты
                        for (e in i downTo 1) {
                            arr[e][j] = arr[e - 1][j]
                        }
                        // спавн нового камня вверху столбца
                        arr[0][j] = randomJewelGeneration()

                    }
                }
            }
        }

    }

    override fun randomJewelGeneration(): Jewel {

        return SimpleJewel(Colors.getRandomColor())
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

    }

    private fun howManyInColumn(count: Int, startPoint: Pair<Int, Int>) {
        if (count>=3) {
            comboCounter ++

            when (count) {
                5 -> fiveInARowVertically(startPoint)
                4 -> fourInARowVertically(startPoint)
                3 -> threeInARowVertically(startPoint)
            }
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

}

    private fun howManyInRow(count: Int, startPoint: Pair<Int, Int>) {
        if (count>=3) {
            comboCounter ++

            when (count) {
                5 -> fiveInARowHorizontally(startPoint)
                4 -> fourInARowHorizontally(startPoint)
                3 -> if (createBomb(startPoint) == false) {
                    threeInARowHorizontally(startPoint)
                }
            }
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


    private fun threeInARowHorizontally(startPoint: Pair<Int, Int>) {
        val i = startPoint.first
        var j = startPoint.second
        repeat(3) {
            deleteJevelOrWhatever(i,j)
            j++
        }
    }



    private fun fourInARowHorizontally(startPoint: Pair<Int, Int>) {
        val i = startPoint.first
        val j = startPoint.second

        deleteJevelOrWhatever(i,j)
        deleteJevelOrWhatever(i,j+1, VerticalLineDestroyer(arr[i][j+2]!!.color))
        deleteJevelOrWhatever(i,j+2)
        deleteJevelOrWhatever(i,j+3)

    }


    private fun fiveInARowHorizontally(startPoint: Pair<Int, Int>){
        val i = startPoint.first
        val j = startPoint.second

        deleteJevelOrWhatever(i,j)
        deleteJevelOrWhatever(i,j+1)
        deleteJevelOrWhatever(i,j+2, SameColorDestroyer(arr[i+3][j]!!.color))
        deleteJevelOrWhatever(i,j+3)
        deleteJevelOrWhatever(i,j+4)
    }




    //Будут елементы, чтоб сломать которые нужно несколько раз возле них ломать камни:
    //
    //Дальше каждый лёд проверяет есть ли возле него null, если да,
    // то урон засчитал и дьду списано единицу прочности и его текстура становится более покоцанной
}