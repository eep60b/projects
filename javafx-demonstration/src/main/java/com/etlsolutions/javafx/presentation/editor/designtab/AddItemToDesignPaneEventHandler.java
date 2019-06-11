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
public class AddItemToDesignPaneEventHandler implements EventHandler<ActionEvent> {

    private final StackPane designPane;

    public AddItemToDesignPaneEventHandler(StackPane designPane) {
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
                    createItem(sh);
                }
            }
        }
    }

    private void createItem(Shape sh) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
