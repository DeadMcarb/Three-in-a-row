package com.example.threeinarow.gameField

import com.example.threeinarow.gameFieldObjects.jewel.Jewel
import com.example.threeinarow.gameFieldObjects.jewel.special.Bomb
import com.example.threeinarow.gameFieldObjects.jewel.special.SpecialJewel
import com.example.threeinarow.gameFieldObjects.jewel.special.VerticalLineDestroyer


class MatrixSkanner(var arr: Array<Array<Jewel?>>)  {

//    @Override
//    public void skanColumns() {
//
//    }




    // ЗАМЕНИЛ СРАВНЕНИЕ ЦВЕТОВ СРАВНЕНИЕМ ОБЪЕКТОВ. ОСТАВИТЬ 2РАВНО ИЛИ ИКВАЛС???????? ИЛИ ЭТО ОДНО И ТО ЖЕ???
fun skanRows() {
    for (i in arr.indices) {
        var color1 = arr[i][0]
        var count = 1
        //на каждой новой строке задаём начальный цвет
        // и ставим счётчик на 1
        for (j in 1 until arr[0].size) {
            val color2 = arr[i][j]

            if (color1 == color2) {
                count++
            }
            if (color1 != color2 || j==arr[0].size-1) {
                color1 = arr[i][j]
                //запоминаем новый цвет

                val startPoint = Pair<Int, Int> (i, j-count+1)
                when(count) {
                    5 -> fiveInARowHorizontally(startPoint)
                    4 -> fourInARowHorizontally(startPoint)
                    3 -> if(createBomb(startPoint) == false) {threeInARowHorizontally(startPoint)}
                    //Заносим 3 или больше прошлых елементов в список для удаления
                }
            }

        }
    }
        printMatrix()
}

    private fun printMatrix() {
        for (i in arr.indices) {
            for (j in arr[0].indices) {
                if (arr[i][j] == null) print("null ") else print(" ${arr[i][j]!!.color}  ")
            }
            println()
        }
    }


    private fun createBomb(startPoint: Pair<Int, Int>): Boolean {
        var x = startPoint.first
        var y = startPoint.second

        //startPoint ЭТО ЖЕ ЛЕВЫЙ ВЕРХНИЙ УГОЛ??

        return checkForBombFunc(x, y,     x, y+1, y+2) ||
                checkForBombFunc(x, y,    x,y-1, y-2) ||
                checkForBombFunc(x, y,   x+2,y+1, y+2) ||
                checkForBombFunc(x, y,   x+2,y-1, y-2)
    }

    private fun checkForBombFunc(X:Int, Y:Int, x:Int, y1:Int, y2:Int): Boolean{
        val startPointJewel = arr[X][Y]!!

        if (y2 > arr.size-1 || y2 < 0) return false
        // ПРОВЕРКА НА ВІХОД ЗА ГРАНИЦЫ МАТРИЦЫ

        if (startPointJewel ==arr[x][y1] && startPointJewel ==arr[x][y2]) {
            val color = startPointJewel.color

            threeInARowHorizontally(Pair(X,Y))
            deleteJevelOrWhatever(x, y1)
            deleteJevelOrWhatever(x, y2)

            arr[X][Y] = Bomb(color)
            return true
        } else return false
    }

    //??????????????????????????????????????????????????????????????????????????
    private fun deleteJevelOrWhatever(x:Int, y:Int, whatToPutHere: Jewel? = null) {
//        if (arr[x][y] is SpecialJewel) { arr[x][y].activated = true
//        } else arr[x][y] = whatToPutHere

        arr[x][y] = whatToPutHere
    }

    private fun threeInARowHorizontally(startPoint: Pair<Int, Int>) {
        var x = startPoint.first
        val y = startPoint.second
        repeat(3) {
            deleteJevelOrWhatever(x,y)
//            ListOfObjectsToRemove.add(Pair(x,y))
            x++
        }
    }
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


    private fun fourInARowHorizontally(startPoint: Pair<Int, Int>) {
        val x = startPoint.first
        val y = startPoint.second

        deleteJevelOrWhatever(x,y)
        deleteJevelOrWhatever(x+1,y, VerticalLineDestroyer(arr[x+2][y]!!.color))
        deleteJevelOrWhatever(x+2,y)
        deleteJevelOrWhatever(x+3,y)

    }
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    private fun fiveInARowHorizontally(startPoint: Pair<Int, Int>){
        val x = startPoint.first
        val y = startPoint.second

        deleteJevelOrWhatever(x,y)
        deleteJevelOrWhatever(x+1,y)
        deleteJevelOrWhatever(x+2,y, VerticalLineDestroyer(arr[x+3][y]!!.color))
        deleteJevelOrWhatever(x+3,y)
        deleteJevelOrWhatever(x+4,y)
    }
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


    //
    //Дальше цыкл по столбцам пускаем
    //

    //Будут елементы, чтоб сломать которые нужно несколько раз возле них ломать камни:
    //
    //Дальше каждый лёд проверяет есть ли возле него null, если да,
    // то урон засчитал и дьду списано единицу прочности и его текстура становится более покоцанной
}