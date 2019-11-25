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
     
    public GwisePoint findIntersection(GwiseLine l1, GwiseLine l2) {
        double a1 = l1.getStartPoint().getY() - l1.getEndPoint().getY();
        double b1 = l1.getEndPoint().getX() - l1.getStartPoint().getX();
        double c1 = a1 * l1.getEndPoint().getX() + b1 * l1.getEndPoint().getY();

        double a2 = l2.getStartPoint().getY() - l2.getEndPoint().getY();
        double b2 = l2.getEndPoint().getX() - l2.getStartPoint().getX();
        double c2 = a2 * l2.getEndPoint().getX() + b2 * l2.getEndPoint().getY();

        double delta = a1 * b2 - a2 * b1;
        return new GwisePoint((b2 * c1 - b1 * c2) / delta, (a1 * c2 - a2 * c1) / delta);
    }
}
