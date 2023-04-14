package com.example.threeinarow.gameField;

import com.example.threeinarow.gameFieldObjects.jewel.Jewel;

public class GameField {

    private final int verticalSize;
    private final int horizontalSize;

    private Jewel[][] jewelArray;

    private int score;
    //За каждый элемент в списке для удаления будет давать n очков

    private int timeLeft;

    public GameField(int verticalSize, int horizontalSize, int timeLeft) {
        this.score = 0;
        this.timeLeft = timeLeft;

        this.verticalSize = verticalSize;
        this.horizontalSize = horizontalSize;

        this.jewelArray = new Jewel[verticalSize][horizontalSize];
    }


    public GameField() {
        this(10, 10 , 3000);
    }



    // этот конструктор не нужен, ВРЕМЕННЫЙ
    public GameField(int verticalSize, int horizontalSize, int timeLeft, Jewel[][] matrix) {
        this.score = 0;
        this.timeLeft = timeLeft;

        this.verticalSize = verticalSize;
        this.horizontalSize = horizontalSize;

        this.jewelArray = matrix;
    }



    public void setScore(int score) {
        this.score = score;
    }

    public void setTimeLeft(int timeLeft) {
        this.timeLeft = timeLeft;
    }

    public int getVerticalSize() {
        return verticalSize;
    }

    public int getHorizontalSize() {
        return horizontalSize;
    }

    public Jewel[][] getJewelArray() {
        return jewelArray;
    }

    public int getScore() {
        return score;
    }

    public int getTimeLeft() {
        return timeLeft;
    }
}
