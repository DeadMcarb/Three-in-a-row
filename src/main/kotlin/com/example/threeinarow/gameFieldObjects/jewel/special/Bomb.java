package com.example.threeinarow.gameFieldObjects.jewel.special;

import javafx.scene.image.Image;
import lombok.SneakyThrows;

import java.io.FileInputStream;

public class Bomb extends SpecialJewel{
    @SneakyThrows
    public Bomb(char color) {
        super(color);
        setTexture(new Image(new FileInputStream("textures\\Bomb.png")));
    }

    //3 на 3 уголок - бомба взрывает 3 на 3
}
