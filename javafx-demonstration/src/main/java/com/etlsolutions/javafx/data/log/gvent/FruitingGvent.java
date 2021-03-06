package com.etlsolutions.javafx.data.log.gvent;

import com.etlsolutions.gwise.data.log.gvent.GventType;
import com.etlsolutions.javafx.data.DataUnitValueWrapper;

/**
 *
 * @author zc
 */
public class FruitingGvent extends Gvent {

    private int NumberPerPlant;
    private String color;
    private String shape;
    private double averageSize;
    private double averageLength;
    private double averageWeight;

    public FruitingGvent() {
    }

    public FruitingGvent(DataUnitValueWrapper valueWrapper, FruitingGventValueWrapper fgdvw) {
        super(valueWrapper, fgdvw);
        color = fgdvw.getColorValueWrapper().getValue();
        shape = fgdvw.getShapeValueWrapper().getValue();
        averageSize = fgdvw.getAverageSize();
        averageLength = fgdvw.getAverageLength();
        averageWeight = fgdvw.getAverageWeight();
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
