package com.etlsolutions.javafx.data.area.subarea.location;

import java.util.HashMap;
import java.util.Map;

/**
 * 10 m X 10 m
 * @author ZhipengChang
 */
public class PlantMapTreeLevel1Node {

    private final int x;
    private final int y;
    private final Map<Integer, Map<Integer, PlantMapTreeLevel2Node>> map = new HashMap<>();

    public PlantMapTreeLevel1Node(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public void addPlantPoint(PlantPoint plantPoint) { 
        
        int x1 = plantPoint.getX();
        int i = (x1 - 1000 * (x1 / 1000)) / 100;
        int y1 = plantPoint.getY();
        int j = (y1 - 1000 * (y1 / 1000)) / 100;
        Map<Integer, PlantMapTreeLevel2Node> m = map.get(i);
        
        if(m == null) {
            m = new HashMap<>();
            
            map.put(i, m);
        }
        
        PlantMapTreeLevel2Node p = m.get(j);
        
        if(p == null) {
            p = new PlantMapTreeLevel2Node(i, j);
            m.put(j, p);
        }
       
        p.addPlantPoint(plantPoint);
    }
    
    public boolean isOccupied(int x, int y, int d) {
        
        for(Map<Integer, PlantMapTreeLevel2Node> m : map.values()) {
            for(PlantMapTreeLevel2Node p : m.values()) {
                if(p.isOccupied(x, y, d)) {
                    return true;
                }
            }
        }
        
        return false;
    }

}
