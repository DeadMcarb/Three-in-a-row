package com.example.threeinarow.gameFieldObjects.jewel.special;

import javafx.scene.image.Image;
import lombok.SneakyThrows;

import java.io.FileInputStream;

import static com.example.threeinarow.gameFieldObjects.jewel.Colors.*;
import static com.example.threeinarow.gameFieldObjects.jewel.Colors.YELLOW;

public class HorizontalLineDestroyer extends SpecialJewel{


    @SneakyThrows
    public HorizontalLineDestroyer(char color) {
        super(color);
        switch (color) {
            case RED -> setTexture(new Image(new FileInputStream("textures\\RedHorizontalArrow.png")));
            case BlUE -> setTexture(new Image(new FileInputStream("textures\\BlueHorizontalArrow.png")));
            case GREEN -> setTexture(new Image(new FileInputStream("textures\\GreenHorizontalArrow.png")));
            case YELLOW -> setTexture(new Image(new FileInputStream("textures\\YellowHorizontalArrow.png")));
        }
    }

}

// СПАВНИТСЯ ЕСЛИ СОБРАТЬ 4 В РЯД ИМЕННО ВЕРТИУКАЛЬНО!
