package com.etlsolutions.javafx.presentation.editor.designtab;

import com.etlsolutions.javafx.data.area.AreaType;
import com.etlsolutions.javafx.data.area.subarea.SubAreaType;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Shape;

/**
 *
 * @author ZhipengChang
 */
public class DesignPaneCancelAreaEventHandler implements EventHandler<ActionEvent> {

    private final StackPane designPane;

    public DesignPaneCancelAreaEventHandler(StackPane designPane) {
        this.designPane = designPane;
    }

    @Override
    public void handle(ActionEvent event) {
        if (designPane.isDisabled()) {
            ObservableList<Node> c = designPane.getChildren();
            Node n = c.get(c.size() - 1);

            if (n instanceof Shape) {

                Shape sh = (Shape) n;
                if (sh.getUserData() instanceof AreaType || sh.getUserData() instanceof SubAreaType) {
                    c.remove(n);
                    designPane.setDisable(false);
                }
            }
        }
    }
}
