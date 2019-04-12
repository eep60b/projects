
package com.etlsolutions.javafx.presentation.editor;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

/**
 *
 * @author zc
 */
public class DesignPaneHeightChangeAdapter implements ChangeListener<Number> {

    private final VBox informationVbox;
    private final ScrollPane informationScrollPane;
    private final TextArea informationTextArea;
    private final TilePane imageTilePane;
    private final StackPane designPane;
    
    public DesignPaneHeightChangeAdapter(VBox informationVbox, ScrollPane informationScrollPane, TextArea informationTextArea, TilePane imageTilePane, StackPane designPane) {
        this.informationVbox = informationVbox;
        this.informationScrollPane = informationScrollPane;
        this.informationTextArea = informationTextArea;
        this.imageTilePane = imageTilePane;
        this.designPane = designPane;
    }

    @Override
    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        //TODO:
    }
    
}
