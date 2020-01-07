package com.etlsolutions.javafx.data.basicshape;

/**
 *
 * @author ZhipengChang
 */
public class ShapeUtils {

    private static final ShapeUtils INSTANCE = new ShapeUtils();

    private ShapeUtils() {
    }

    public static ShapeUtils getInstance() {
        return INSTANCE;
    }

    /**
     * This code it taken from
     * https://rosettacode.org/wiki/Find_the_intersection_of_two_lines
     *
     *
     * @param l1
     * @param l2
     * @return
     */
    public GwisePoint findIntersection(GwiseLine l1, GwiseLine l2) {

        GwisePoint start1 = l1.getStartPoint();
        GwisePoint end1 = l1.getEndPoint();
        GwisePoint start2 = l2.getStartPoint();
        GwisePoint end2 = l2.getEndPoint();
        if (start1.equals(start1.equals(start2) || start1.equals(end2) || end1.equals(start1) || end1.equals(end2))) {
            return null;
        }

        double a1 = l1.getStartPoint().getY() - l1.getEndPoint().getY();
        double b1 = l1.getEndPoint().getX() - l1.getStartPoint().getX();
        double c1 = a1 * l1.getEndPoint().getX() + b1 * l1.getEndPoint().getY();

        double a2 = l2.getStartPoint().getY() - l2.getEndPoint().getY();
        double b2 = l2.getEndPoint().getX() - l2.getStartPoint().getX();
        double c2 = a2 * l2.getEndPoint().getX() + b2 * l2.getEndPoint().getY();

        double delta = a1 * b2 - a2 * b1;

        double valueX = (b2 * c1 - b1 * c2) / delta;
        double valueY = (a1 * c2 - a2 * c1) / delta;

        if (isInsideLine(valueX, valueY, l1) && isInsideLine(valueX, valueY, l2)) {
            GwisePoint p = new GwisePoint(valueX, valueY);
            p.setJointPoint(true);
            return p;
        }
        return null;
    }

    private boolean isInsideLine(double valueX, double valueY, GwiseLine l) {

        if (Double.isInfinite(valueX) || Double.isInfinite(valueY)) {
            return false;
        }

        double lWest = l.getStartPoint().getX() < l.getEndPoint().getX() ? l.getStartPoint().getX() : l.getEndPoint().getX();
        double lEast = l.getStartPoint().getX() > l.getEndPoint().getX() ? l.getStartPoint().getX() : l.getEndPoint().getX();
        double lNorth = l.getStartPoint().getY() < l.getEndPoint().getY() ? l.getStartPoint().getY() : l.getEndPoint().getY();
        double lSouth = l.getStartPoint().getY() > l.getEndPoint().getY() ? l.getStartPoint().getY() : l.getEndPoint().getY();

        return valueX > lWest && valueX < lEast && valueY > lNorth && valueY < lSouth;
    }
}
