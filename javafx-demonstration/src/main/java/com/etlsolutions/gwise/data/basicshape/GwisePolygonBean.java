package com.etlsolutions.gwise.data.basicshape;

import java.util.ArrayList;
import java.util.List;

/**
 * The GwisePolygon class represent a simple polygon (lines are not intersect
 * each other) shape for area or subarea. The starting point will be the leftest
 * point (smallest x value). If serval points has the same smallest x value, the
 * smallest, the point with smallest y value. will be used as the first point.
 * This guarantees the first point is not a convex vert.
 *
 * @author ZhipengChang
 */
public class GwisePolygonBean implements GwiseShapeBean {

    private List<GwisePointBean> points;

    public GwisePolygonBean() {
    }
    
    public GwisePolygonBean(GwisePolygon p) {

        points = new ArrayList<>();
        for(GwisePoint point : p.getPoints()) {
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
