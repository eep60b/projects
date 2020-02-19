package com.etlsolutions.gwise.data.basicshape;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ZhipengChang
 */
public class GwisePolylineBean {
    
    private List<GwisePointBean> points;

    public GwisePolylineBean() {
    }
    
    public GwisePolylineBean(GwisePolyline line) {
        points = new ArrayList<>();
        
        for(GwisePoint point : line.getPoints()) {
            points.add(new GwisePointBean(point));
        }
    }

    public List<GwisePointBean> getPoints() {
        return points;
    }

    public void setPoints(List<GwisePointBean> points) {
        this.points = points;
    }
}
