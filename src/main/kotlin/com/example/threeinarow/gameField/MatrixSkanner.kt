package com.example.threeinarow.gameField

import com.example.threeinarow.gameFieldObjects.SimpleJewel



//ТУТ В КОНСТРУКТОРЕ В 2Д МАССИВЕ БЫЛ АБСТРАКТНЫЙ Jewel
class MatrixSkanner(var arr: Array<Array<SimpleJewel>>)  {
    val ListOfObjectsToRemove = HashSet<Pair<Int, Int>>()

    //Список для удаления должен быть без повторений, чтоб было проще. ++++
    // Надо использовать хешСет или мапу (второе лучше можно сделать как раз на цве цифры сразу?) +++++


//    ArrayList<> ListOfObjectsToRemove;
//    @Override
//    public void skanColumns() {
//
//    }



//  поиск каждым камнем соседей идёт нафиг, будет цикл
fun skanRows() {
    for (i in arr.indices) {
        var color1 = arr[i][0].color
        var count = 1
        //на каждой новой строке задаём начальный цвет
        // и ставим счётчик на 1
        for (j in 1 until arr[0].size) {
            val color2 = arr[i][j].color

            if (color1 == color2) {
                count++
            } else {
                color1 = arr[i][j].color
                //запоминаем новый цвет

                val startPoint = Pair<Int, Int> (i, j-count)
                when(count) {
                    5 -> fiveInARow(startPoint)
                    4 -> fourInARow(startPoint)
                    3 -> if(createBomb(startPoint) == false) {threeInARow(startPoint)}
                    //Заносим 3 или больше прошлых елементов в список для удаления
                }
            }

        }
    }
}

    /// эти функции работают только по горизонтали
    private fun createBomb(startPoint: Pair<Int, Int>): Boolean {

        var x = startPoint.first
        var y = startPoint.second

        val currentColor = arr[x][y].color

        //startPoint ЭТО ЖЕ ЛЕВЫЙ ВЕРХНИЙ УГОЛ??

        if (currentColor ==arr[x][y+1].color && currentColor ==arr[x][y+2].color) {
            //            arr[x][y] = null
            //            arr[x][y] = null
            //            arr[x][y] = null
            ListOfObjectsToRemove.add(Pair(x,y))
            ListOfObjectsToRemove.add(Pair(x,y+1))
            ListOfObjectsToRemove.add(Pair(x,y+2))
            //        arr[x][y] = Bomb(arr[x][y].color)
            return true
        }

        if (currentColor ==arr[x][y-1].color && currentColor ==arr[x][y-2].color) {
            //            arr[x][y] = null
            //            arr[x][y] = null
            //            arr[x][y] = null
            ListOfObjectsToRemove.add(Pair(x,y))
            ListOfObjectsToRemove.add(Pair(x,y-1))
            ListOfObjectsToRemove.add(Pair(x,y-2))
            //        arr[x][y] = Bomb(arr[x][y].color)
            return true
        }

        if (currentColor ==arr[x+2][y+1].color && currentColor ==arr[x+2][y+2].color) {
            //            arr[x][y] = null
            //            arr[x][y] = null
            //            arr[x][y] = null
            ListOfObjectsToRemove.add(Pair(x+2,y))
            ListOfObjectsToRemove.add(Pair(x+2,y+1))
            ListOfObjectsToRemove.add(Pair(x+2,y+2))
            //        arr[x][y] = Bomb(arr[x+2][y].color)
            return true
        }

        if (currentColor ==arr[x+2][y-1].color && currentColor ==arr[x+2][y-2].color) {
            //            arr[x][y] = null
            //            arr[x][y] = null
            //            arr[x][y] = null
            ListOfObjectsToRemove.add(Pair(x+2,y))
            ListOfObjectsToRemove.add(Pair(x+2,y-1))
            ListOfObjectsToRemove.add(Pair(x+2,y-2))
            //        arr[x][y] = Bomb(arr[x+2][y].color)
            return true
        }
        return false
    }

    /// ТАК А ЗАЧЕМ МНЕ СПИСОК ДЛЯ УДАЛЕНИЯ, ЕСЛИ Я И ТАК МОГУ СРАЗУ НАХОДИТЬ 3 В РЯД И УДАЛЯТЬ???

    private fun threeInARow(startPoint: Pair<Int, Int>) {
        var x = startPoint.first
        var y = startPoint.second
        repeat(3) {
            //            arr[x][y] = null
            ListOfObjectsToRemove.add(Pair(x,y))
            x++
            y++
        }
    }

    private fun fourInARow(startPoint: Pair<Int, Int>) {
        var x = startPoint.first
        var y = startPoint.second

//        arr[x+1][y] = VerticalLineDestroyer(arr[x+1][y].color)

        repeat(4) {
//            arr[x][y] = null
            ListOfObjectsToRemove.add(Pair(x,y))
            x++
            y++
        }
    }


    private fun fiveInARow(startPoint: Pair<Int, Int>){
        var x = startPoint.first
        var y = startPoint.second

        //        arr[x+2][y] = VerticalLineDestroyer(arr[x+2][y].color)

        repeat(5) {
            //            arr[x][y] = null  а вообще надо не просто нуль, а сделать фунцию
            //            ремув, котрая будет ещ' делать проверку на всякие там бомбы и прочее

            //            а вообще наверное всё таки лучше заносить все эти камни в список для удаления
            //            ччтоб потом функциия ремув шла по списку и удаляла всё это на пале


            ListOfObjectsToRemove.add(Pair(x,y))
            x++
            y++
        }
    }

    //
    //Дальше цыкл по столбцам пускаем
    //
    //Чтоб ничего не сломать по вертикали нужно заносить номера элементов для удаления в отдельный список
    //
    //Будут елементы, чтоб сломать которые нужно несколько раз возле них ломать камни:
    //
    //Мы собрали список для удаления, удаляем и ставим null
    //
    //Дальше каждый камень проверяет есть ли возле него null, если да,
    // то урон засчитал и камню списано единицу прочности и его текстура становится более покоцанной
}