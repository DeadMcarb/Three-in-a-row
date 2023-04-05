package com.example.threeinarow.gameFieldObjects;

public abstract class Jewel {
    private String color;

    public Jewel(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    //    https://stackoverflow.com/questions/8180430/how-to-override-equals-method-in-java
    public boolean equals(Object o) {

        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of Jewel or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Jewel)) {
            return false;
        }

        // typecast o to Jewel so that we can compare data members
        Jewel c = (Jewel) o;

        // Compare the data members and return accordingly
        return color.equals(c.getColor());
    }

}
