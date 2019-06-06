package com.etlsolutions.javafx.data.area.subarea.location;

import java.util.HashMap;
import java.util.Map;

/**
 * 100 m X 100 m
 *
 * @author ZhipengChang
 */
public class PlantMapTreeRoot {

    private final Map<Integer, Map<Integer, PlantMapTreeLevel1Node>> map = new HashMap<>();

    public void addPlantPoint(PlantPoint plantPoint) {

        int x1 = plantPoint.getX();
        int y1 = plantPoint.getY();
        Map<Integer, PlantMapTreeLevel1Node> m = map.get(x1 / 1000);

        if (m == null) {
            m = new HashMap<>();

            map.put(x1 / 1000, m);
        }

        PlantMapTreeLevel1Node p = m.get(y1 / 1000);

        if (p == null) {
            p = new PlantMapTreeLevel1Node(x1/1000, y1/1000);
            m.put(y1 / 1000, p);
        }

        p.addPlantPoint(plantPoint);
    }

    public boolean isOccupied(int x, int y, int d) {

        for (Map<Integer, PlantMapTreeLevel1Node> m : map.values()) {
            for (PlantMapTreeLevel1Node p : m.values()) {
                if (p.isOccupied(x, y, d)) {
                    return true;
                }
            }
        }

        return false;
    }
}
