package com.etlsolutions.javafx.data.log.gvent;

import java.util.Date;

/**
 *
 * @author zc
 */
public class FloweringGvent extends Gvent {

    private int numberPerPlant = -1;
    private String color;

    public int getNumberPerPlant() {
        return numberPerPlant;
    }

    public void setNumberPerPlant(int numberPerPlant) {
        this.numberPerPlant = numberPerPlant;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    @Override
    public GventType getType() {
        return GventType.FLOWERING;
    }    
}
