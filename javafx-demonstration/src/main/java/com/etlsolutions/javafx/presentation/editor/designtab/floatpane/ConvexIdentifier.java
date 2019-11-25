package com.etlsolutions.javafx.presentation.editor.designtab.floatpane;

import java.util.List;


/*
Given a list of points that form a polygon when joined sequentially, find if this polygon is convex
(Convex polygon definition: https://en.wikipedia.org/wiki/Convex_polygon)
Note:
There are at least 3 and at most 10,000 points.
Coordinates are in the range -10,000 to 10,000.
You may assume the polygon formed by given points is always a simple polygon (Simple polygon definition).
In other words, we ensure that exactly two edges intersect at each vertex, and that edges otherwise don't intersect each other.
Example 1:
[[0,0],[0,1],[1,1],[1,0]]
Answer: True
Explanation: https://leetcode.com/static/images/problemset/polygon_convex.png?_=6146986
Example 2:
[[0,0],[0,10],[10,10],[10,0],[5,5]]
Answer: False
Explanation: https://leetcode.com/static/images/problemset/polygon_not_convex.png?_=6146986
 */
/**
 * Approach: Using Cross Product To see if a polygon is convex, calculate the
 * angles at each of the polygon’s corners. If all of the angles have the same
 * sign (either positive or negative depending on the orientation), then the
 * polygon is convex.
 *
 * Rather than actually finding the angles, we can just find the cross product
 * of the segments on either side of the angles. If the segments at point B are
 * AB and BC, then the cross product has value |AB| * |BC| * Sin(theta) where
 * theta is the angle between the two segments. Because the lengths are always
 * positive, the result is positive if the angle is positive and negative if the
 * angle is negative.
 *
 * Note: Dot Product: Often be used to determine two vectors perpendicular to
 * each other or not. And also could be used to calculate the projection on the
 * other vector. Cross Product: Often be used to determine the direction of
 * plane that composed of the two vectors.
 *
 * The Other Applications of Cross Product: Largest Triangle Area:
 * https://github.com/cherryljr/LeetCode/blob/master/Largest%20Triangle%20Area.java
 * https://github.com/cherryljr/NowCoder/blob/master/%E7%BA%BF%E6%AE%B5%E7%9B%B8%E4%BA%A4%E7%82%B9%E4%B8%AA%E6%95%B0.java
 */
/**
 *
 * @author ZhipengChang
 */
public class ConvexIdentifier {

    public boolean isConvex(List<List<Integer>> points) {
        /*
        For each set of three adjacent points A, B, C, find the cross product AB x BC. If the sign of
        all the cross products is the same, the angles are all positive or negative (depending on the
        order in which we visit them) so the polygon is convex.
         */
        boolean gotNegative = false;
        boolean gotPositive = false;
        int numPoints = points.size();
        int B, C;
        for (int A = 0; A < numPoints; A++) {
            // Trick to calc the last 3 points: n - 1, 0 and 1.
            B = (A + 1) % numPoints;
            C = (B + 1) % numPoints;

            int crossProduct
                    = crossProductLength(
                            points.get(A).get(0), points.get(A).get(1),
                            points.get(B).get(0), points.get(B).get(1),
                            points.get(C).get(0), points.get(C).get(1));
            if (crossProduct < 0) {
                gotNegative = true;
            } else if (crossProduct > 0) {
                gotPositive = true;
            }
            // if the crossProduct doesn't have the same sign, then it's concave polygon
            if (gotNegative && gotPositive) {
                return false;
            }
        }

        // If we got this far, the polygon is convex.
        return true;
    }

    /*
    Return the cross product AB x BC.
    The cross product is a vector perpendicular to AB and BC having length |AB| * |BC| * Sin(theta) and
    with direction given by the right-hand rule. For two vectors in the X-Y plane, the result is a
    vector with X and Y components 0 so the Z component gives the vector's length and direction.
     */
    private int crossProductLength(int Ax, int Ay, int Bx, int By, int Cx, int Cy) {
        // Get the vectors' coordinates.
        int ABx = Bx - Ax;
        int ABy = By - Ay;
        int ACx = Cx - Ax;
        int ACy = Cy - Ay;

        // Calculate the Z coordinate of the cross product.
        return ABx * ACy - ABy * ACx;
    }
}
