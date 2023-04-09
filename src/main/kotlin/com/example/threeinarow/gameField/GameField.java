package com.example.threeinarow.gameField;

import com.example.threeinarow.gameFieldObjects.jewel.Jewel;

public class GameField {

    Jewel[][] jewelArray;

    int score;
    //За каждый элемент в списке для удаления будет давать n очков

    int timeLeft;

    public GameField(int verticalSize, int gorizontalSize, int timeLeft) {
        this.score = 0;
        this.timeLeft = timeLeft;
        this.jewelArray = new Jewel[verticalSize][gorizontalSize];
    }




}
