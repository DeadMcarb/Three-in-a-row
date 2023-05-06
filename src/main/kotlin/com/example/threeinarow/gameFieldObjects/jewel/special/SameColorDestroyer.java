package com.example.threeinarow.gameFieldObjects.jewel.special;

import javafx.scene.image.Image;
import lombok.SneakyThrows;

import java.io.FileInputStream;

public class SameColorDestroyer extends SpecialJewel{


    @SneakyThrows
    public SameColorDestroyer(char color) {
        super(color);
        setTexture(new Image(new FileInputStream("textures\\Palette.png")));
    }

    //5 в ряд - убивает все элементы на поле этого цвета
}
