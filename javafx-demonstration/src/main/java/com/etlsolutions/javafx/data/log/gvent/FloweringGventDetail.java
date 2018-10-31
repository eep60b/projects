package com.etlsolutions.javafx.data.log.gvent;

/**
 *
 * @author zc
 */
public class FloweringGventDetail implements GventDetail {

    private int numberPerPlant;
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
