package com.etlsolutions.javafx.data.basicshape;

import com.etlsolutions.gwise.data.basicshape.GwisePoint;
import com.etlsolutions.gwise.data.basicshape.ShapeUtils;
import com.etlsolutions.gwise.data.basicshape.GwiseLine;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * Test of class ShapeUtils.
 *
 * @author ZhipengChang
 */
public class ShapeUtilsTest {

    private final ShapeUtils instance = ShapeUtils.getInstance();

    /**
     * Test of findIntersection method when two lines intersect each other.
     */
    @Test
    public void testFindIntersection() {

        GwiseLine l1 = new GwiseLine(new GwisePoint(4, 0), new GwisePoint(6, 10));
        GwiseLine l2 = new GwiseLine(new GwisePoint(0, 3), new GwisePoint(10, 7));

        assertEquals(new GwisePoint(5, 5), instance.findIntersection(l1, l2));
    }

    /**
     * Test of findIntersection method when two lines do not intersect each
     * other.
     */
    @Test
    public void testFindIntersection_no_intersection() {

        GwiseLine l1 = new GwiseLine(new GwisePoint(0, 0), new GwisePoint(1, 1));
        GwiseLine l2 = new GwiseLine(new GwisePoint(1, 2), new GwisePoint(4, 5));

        assertEquals(new GwisePoint(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY), instance.findIntersection(l1, l2));
    }

}
