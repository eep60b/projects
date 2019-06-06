package com.etlsolutions.javafx.data.area.subarea.location;

/**
 *
 * @author ZhipengChang
 */
public class PlantPoint {

    private final int x;
    private final int y;
 

    public PlantPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isOccupied(int x, int y, int d) {
        return Math.abs(this.x - x) <= d && Math.abs(this.y - y) <= d;
    }    
}
