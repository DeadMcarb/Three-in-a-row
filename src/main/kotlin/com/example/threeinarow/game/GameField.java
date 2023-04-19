package com.example.threeinarow.game;

import com.example.threeinarow.gameFieldObjects.jewel.Jewel;

public class GameField {
    private final int verticalSize;
    private final int horizontalSize;

    private Jewel[][] jewelArray;


    /// ВРЕМЕННО
//    public GameField(Jewel[][] jewelArray) {
//        this(jewelArray.length)
//    }


    public GameField(int verticalSize, int horizontalSize, Jewel[][] jewelArray) {
        this.verticalSize = verticalSize;
        this.horizontalSize = horizontalSize;
        this.jewelArray = jewelArray;
    }

    public GameField(int verticalSize, int horizontalSize) {
        this(verticalSize, horizontalSize, new Jewel[verticalSize][horizontalSize]);
    }



    public GameField() {
        this(10, 10);
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

    public void setJewelArray(Jewel[][] jewelArray) {
        this.jewelArray = jewelArray;
    }
}
