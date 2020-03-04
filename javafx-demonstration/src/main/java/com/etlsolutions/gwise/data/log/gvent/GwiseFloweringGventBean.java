package com.etlsolutions.gwise.data.log.gvent;

/**
 *
 * @author zc
 */
public class GwiseFloweringGventBean extends GwiseGventBean {

    private String flowerType;
    private int count;
    private String color;

    public GwiseFloweringGventBean() {
    }

    public GwiseFloweringGventBean(GwiseFloweringGvent gvent) {
        super(gvent);
        flowerType = gvent.getFlowerType();
        this.count = gvent.getCount();
        this.color = gvent.getColor();
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
