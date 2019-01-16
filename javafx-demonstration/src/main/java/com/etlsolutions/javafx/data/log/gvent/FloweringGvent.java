package com.etlsolutions.javafx.data.log.gvent;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;

/**
 *
 * @author zc
 */
public class FloweringGvent extends Gvent {

    private String flowerType;
    private int count;
    private String color;

    public FloweringGvent() {
    }

    public FloweringGvent(DataUnitValueWrapper valueWrapper, FloweringGventValueWrapper fgdvw) {
        super(valueWrapper, fgdvw);
        flowerType = fgdvw.getFlowerTypeValueWrapper().getValue();
        count = fgdvw.getNumberPerPlantValueWrapper().getValue();
        color = fgdvw.getColorValueWrapper().getValue();
    }

    public String getFlowerType() {
        return flowerType;
    }

    public void setFlowerType(String flowerType) {
        this.flowerType = flowerType;
    }
    
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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
