package com.example.threeinarow.gameFieldObjects.jewel.special;

import com.example.threeinarow.gameFieldObjects.jewel.Jewel;

public abstract class SpecialJewel extends Jewel {
    private boolean activated;


    public SpecialJewel(char color) {
        super(color);
        this.activated = false;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public abstract void action();

}