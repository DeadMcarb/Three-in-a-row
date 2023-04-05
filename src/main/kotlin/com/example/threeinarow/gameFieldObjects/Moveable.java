package com.example.threeinarow.gameFieldObjects;

public interface Moveable {
    public void replaceWith(int x, int y);

    //  Функция будет менять камни местами только тогда, когда будет хоть одно 3 в ряд,
    //  которое мы проверяли цыклами
    //  (вроде противоречий нету, поменяли в матрице местами, проверили, если нет, то меняем обратно)


    //Добавить счётчик ходов.
    // С него будет списываться 1 ход за каждый успешный вызов функции ReplaceWith (поменять местами)

    public void fallDown(int x, int y);
}
