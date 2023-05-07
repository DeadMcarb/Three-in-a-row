package com.example.threeinarow.gameFieldObjects.jewel.special;

import javafx.scene.image.Image;
import lombok.SneakyThrows;

import java.io.FileInputStream;

import static com.example.threeinarow.gameFieldObjects.jewel.Colors.*;
import static com.example.threeinarow.gameFieldObjects.jewel.Colors.YELLOW;

public class VerticalLineDestroyer extends SpecialJewel {

    @SneakyThrows
    public VerticalLineDestroyer(char color) {
        super(color);

        switch (color) {
            case RED -> setTexture(new Image(new FileInputStream("textures\\RedVerticalArrow.png")));
            case BlUE -> setTexture(new Image(new FileInputStream("textures\\BlueVerticalArrow.png")));
            case GREEN -> setTexture(new Image(new FileInputStream("textures\\GreenVerticalArrow.png")));
            case YELLOW -> setTexture(new Image(new FileInputStream("textures\\YellowVerticalArrow.png")));
        }
    }

}

// СПАВНИТСЯ ЕСЛИ СОБРАТЬ 4 В РЯД ИМЕННО ГОРИЗОНТАЛЬНО!

