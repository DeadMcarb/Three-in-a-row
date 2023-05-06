package com.example.threeinarow.gameFieldObjects.jewel.special;

import javafx.scene.image.Image;
import lombok.SneakyThrows;

import java.io.FileInputStream;

public class HorizontalLineDestroyer extends SpecialJewel{


    @SneakyThrows
    public HorizontalLineDestroyer(char color) {
        super(color);
        setTexture(new Image(new FileInputStream("textures\\HorizontalArrow.png")));
    }

}

// СПАВНИТСЯ ЕСЛИ СОБРАТЬ 4 В РЯД ИМЕННО ВЕРТИУКАЛЬНО!
