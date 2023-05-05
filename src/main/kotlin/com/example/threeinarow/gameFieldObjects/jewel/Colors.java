package com.example.threeinarow.gameFieldObjects.jewel;

import java.util.Random;

public class Colors {
    public static final char RED = 'R';
    public static final char BlUE = 'B';
    public static final char GREEN = 'G';
    public static final char YELLOW = 'Y';



    public static char getRandomColor() {
        Random random = new Random();
        int randomIndex = random.nextInt(4);
        char result = 'w';

        switch (randomIndex) {
            case 0 -> {
                result = RED;
            }
            case 1 -> {
                result = BlUE;
            }
            case 2 -> {
                result = GREEN;
            }
            case 3 -> {
                result = YELLOW;
            }
        }
        return result;
    }

}
