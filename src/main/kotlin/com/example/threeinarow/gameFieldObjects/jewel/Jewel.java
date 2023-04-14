package com.example.threeinarow.gameFieldObjects.jewel;

import static com.example.threeinarow.gameFieldObjects.jewel.Colors.*;

public abstract class Jewel {
    private char color;

    private String texture;

    public Jewel(char color) {
        this.color = color;
        switch (color) {
            case RED -> texture = "D:\\IdeaProjects\\Three-in-a-row\\src\\main\\kotlin\\com\\example\\threeinarow\\textures\\Red.png";
            case BlUE -> texture = "D:\\IdeaProjects\\Three-in-a-row\\src\\main\\kotlin\\com\\example\\threeinarow\\textures\\Blue.png";
            case GREEN -> texture = "D:\\IdeaProjects\\Three-in-a-row\\src\\main\\kotlin\\com\\example\\threeinarow\\textures\\Green.png";
            case YELLOW -> texture = "D:\\IdeaProjects\\Three-in-a-row\\src\\main\\kotlin\\com\\example\\threeinarow\\textures\\Yellow.png";
        }
    }

    public String getTexture() {
        return texture;
    }

    public char getColor() {
        return color;
    }

    @Override
    //    https://stackoverflow.com/questions/8180430/how-to-override-equals-method-in-java
    public boolean equals(Object o) {

        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        if (o == null)
            return false;

        /* Check if o is an instance of Jewel or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Jewel)) {
            return false;
        }

        // typecast o to Jewel so that we can compare data members
        Jewel c = (Jewel) o;

        // Compare the data members and return accordingly
        return  color == c.color;
    }

}
