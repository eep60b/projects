package com.etlsolutions.javafx.presentation.editor.designtab.anchor;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.basicshape.GwisePoint;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Shape;

/**
 *
 * @author zc
 */
public class AnchorController {

    private static final AnchorController INSTANCE = new AnchorController();

    private AnchorController() {
    }

    public static AnchorController getInstance() {
        return INSTANCE;
    }

    /**
     * Check if there are anchors on the design pane.If there are no anchors,
     * add new ones which represents the points.If there are old anchors, use
     * them by modify their position to match the points and enable them.If the
     * number of old anchors are fewer than the points, add some more. If the
     * number of old anchors are more than the number of points, then only
     * enable some of them enough for the points.
     *
     * @param shape
     */
    public void enablelAnchors(final Shape shape) {

        StackPane designPane = (StackPane) shape.getParent();
        ObservableListWrapperA<GwisePoint> points = (ObservableListWrapperA<GwisePoint>) shape.getUserData();
        Object obj = designPane.getUserData();

        ObservableListWrapperA<Anchor> anchors = (obj == null) ? new ObservableListWrapperA<Anchor>() : (ObservableListWrapperA<Anchor>) obj;

        int extra = points.size() - anchors.size();

        for (int i = 0; i < extra; i++) {

            Anchor anchor = new Anchor();
            anchors.add(anchor);
            designPane.getChildren().add(anchor);
        }

        for (int i = 0; i < points.size(); i++) {

            GwisePoint point = points.get(i);
            Anchor anchor = anchors.get(i);
            anchor.setCenterX(point.getX());
            anchor.getXProperty().removeListener();
            anchor.getXProperty().addListener(new AnchorXListener(point));
            anchor.setCenterY(point.getY());
            anchor.getYProperty().removeListener();
            anchor.getYProperty().addListener(new AnchorYListener(point));
            anchor.setDisable(false);
            anchor.setVisible(true);
            anchor.toFront();
        }
    }

    public void disnablelAnchors(Shape shape) {

        StackPane designPane = (StackPane) shape.getParent();
        Object obj = designPane.getUserData();
        ObservableListWrapperA<Anchor> anchors = (obj == null) ? new ObservableListWrapperA<Anchor>() : (ObservableListWrapperA<Anchor>) obj;

 
        for (Anchor anchor : anchors) {
            anchor.getXProperty().removeListener();
            anchor.getYProperty().removeListener();
            anchor.setDisable(true);
            anchor.setVisible(false);
            anchor.toBack();
        }
    }        
}
