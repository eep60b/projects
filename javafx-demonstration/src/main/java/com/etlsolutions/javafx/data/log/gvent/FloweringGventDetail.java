package com.etlsolutions.javafx.data.log.gvent;

/**
 *
 * @author zc
 */
public class FloweringGventDetail implements GventDetail {

    private String flowerType;    
    private int numberPerPlant;
    private String color;

    public String getFlowerType() {
        return flowerType;
    }

    public void setFlowerType(String flowerType) {
        this.flowerType = flowerType;
    }
    
    public int getCount() {
        return numberPerPlant;
    }

    public void setCount(int numberPerPlant) {
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
