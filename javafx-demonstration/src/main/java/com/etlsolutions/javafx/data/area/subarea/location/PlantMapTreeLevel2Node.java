package com.etlsolutions.javafx.data.area.subarea.location;

import java.util.HashMap;
import java.util.Map;

/**
 * 1 m X 1 m
 * @author ZhipengChang
 */
public class PlantMapTreeLevel2Node {

    private final int x;
    private final int y;
    private final Map<Integer, Map<Integer, PlantPoint>> map = new HashMap<>();

    public PlantMapTreeLevel2Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    
    public void addPlantPoint(PlantPoint plantPoint) { 
        
        int x1 = plantPoint.getX();
        int i = (x1 - 100* (x1 / 100))/10;
        int y1 = plantPoint.getY();
        int j = (y1 - 100 * (y1 / 100))/10;
        Map<Integer, PlantPoint> m = map.get(i);
        
        if(m == null) {
            m = new HashMap<>();
            map.put(i, m);
        }
       
        m.put(j, plantPoint);
    }
    
    public boolean isOccupied(int x, int y, int d) {
        
        for(Map<Integer, PlantPoint> m : map.values()) {
            for(PlantPoint p : m.values()) {
                if(p.isOccupied(x, y, d)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
