package com.example.threeinarow.gameFieldObjects.jewel.special;

import javafx.scene.image.Image;
import lombok.SneakyThrows;

import java.io.FileInputStream;

public class VerticalLineDestroyer extends SpecialJewel {

    @SneakyThrows
    public VerticalLineDestroyer(char color) {
        super(color);
        setTexture(new Image(new FileInputStream("textures\\VerticalArrow.png")));
    }

}

// СПАВНИТСЯ ЕСЛИ СОБРАТЬ 4 В РЯД ИМЕННО ГОРИЗОНТАЛЬНО!

