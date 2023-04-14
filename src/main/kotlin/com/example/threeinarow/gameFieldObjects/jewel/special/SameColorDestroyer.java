package com.example.threeinarow.gameFieldObjects.jewel.special;

public class SameColorDestroyer extends SpecialJewel{
    public SameColorDestroyer(char color) {
        super(color);
    }

    @Override
    public void action() {

    }

    //5 в ряд - убивает все элементы на поле этого цвета
}
