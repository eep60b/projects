/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.javafx.presentation.editor.designtab.floatpane;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.basicshape.GwisePoint;
import com.etlsolutions.gwise.data.basicshape.GwisePolygon;
import com.etlsolutions.gwise.data.basicshape.GwiseTriangle;
import java.util.List;

/**
 * The PolygonTriangleConvertor class convert a polygon into a set of triangles.
 *
 * @author ZhipengChang
 */
public class PolygonTriangleConvertor {

    public ObservableListWrapperA<GwiseTriangle> getTriangles(GwisePolygon polygon) {

        ObservableListWrapperA<GwisePoint> points = polygon.getPoints();

        ObservableListWrapperA<GwiseTriangle> list = new ObservableListWrapperA<>();

        while (points.size() >= 3) {
            GwiseTriangle triangle = new GwiseTriangle(points.get(0), points.get(1), points.get(points.size() - 1));
            list.add(triangle);
            points.remove(0);
            points = new GwisePolygon(points).getPoints();
        }

        return list;
    }

}
