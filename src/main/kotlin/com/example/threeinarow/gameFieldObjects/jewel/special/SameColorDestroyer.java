package com.example.threeinarow.gameFieldObjects.jewel.special;

public class SameColorDestroyer extends SpecialJewel{
    public SameColorDestroyer(String color) {
        super(color);
    }

    @Override
    void action() {

    }

    //5 в ряд - убивает все элементы на поле этого цвета
}
