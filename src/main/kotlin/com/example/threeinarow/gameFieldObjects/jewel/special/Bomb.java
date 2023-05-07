package com.example.threeinarow.gameFieldObjects.jewel.special;

import javafx.scene.image.Image;
import lombok.SneakyThrows;

import java.io.FileInputStream;

import static com.example.threeinarow.gameFieldObjects.jewel.Colors.*;
import static com.example.threeinarow.gameFieldObjects.jewel.Colors.YELLOW;

public class Bomb extends SpecialJewel{
    @SneakyThrows
    public Bomb(char color) {
        super(color);

        switch (color) {
            case RED -> setTexture(new Image(new FileInputStream("textures\\RedBomb.png")));
            case BlUE -> setTexture(new Image(new FileInputStream("textures\\BlueBomb.png")));
            case GREEN -> setTexture(new Image(new FileInputStream("textures\\GreenBomb.png")));
            case YELLOW -> setTexture(new Image(new FileInputStream("textures\\YellowBomb.png")));
        }
    }

    //3 на 3 уголок - бомба взрывает 3 на 3
}
