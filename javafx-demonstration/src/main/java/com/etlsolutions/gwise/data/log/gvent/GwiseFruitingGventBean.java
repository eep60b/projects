package com.etlsolutions.gwise.data.log.gvent;

/**
 *
 * @author zc
 */
public class GwiseFruitingGventBean extends GwiseGventBean {

    private int NumberPerPlant;
    private String color;
    private String shape;
    private double averageSize;
    private double averageLength;
    private double averageWeight;

    public GwiseFruitingGventBean() {
    }

    public GwiseFruitingGventBean(GwiseFruitingGvent gvent) {
        super(gvent);
        NumberPerPlant = gvent.getNumberPerPlant();
        this.color = gvent.getColor();
        this.shape = gvent.getShape();
        this.averageSize = gvent.getAverageSize();
        this.averageLength = gvent.getAverageLength();
        this.averageWeight = gvent.getAverageWeight();
    }


    public int getNumberPerPlant() {
        return NumberPerPlant;
    }

    public void setNumberPerPlant(int NumberPerPlant) {
        this.NumberPerPlant = NumberPerPlant;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public double getAverageSize() {
        return averageSize;
    }

    public void setAverageSize(double averageSize) {
        this.averageSize = averageSize;
    }

    public double getAverageLength() {
        return averageLength;
    }

    public void setAverageLength(double averageLength) {
        this.averageLength = averageLength;
    }

    public double getAverageWeight() {
        return averageWeight;
    }

    public void setAverageWeight(double averageWeight) {
        this.averageWeight = averageWeight;
    }

    @Override
    public GventType getType() {
        return GventType.FRUITING;
    }
}
