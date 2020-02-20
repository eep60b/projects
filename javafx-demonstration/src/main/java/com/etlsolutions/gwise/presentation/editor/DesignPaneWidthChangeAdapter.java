package com.etlsolutions.gwise.presentation.editor;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.chart.LineChart;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

/**
 *
 * @author zc
 */
public class DesignPaneWidthChangeAdapter implements ChangeListener<Number> {

    public DesignPaneWidthChangeAdapter(VBox informationVbox, ScrollPane informationScrollPane, TextArea informationTextArea, TilePane imageTilePane, StackPane designPane, LineChart backgroudLineChart) {
        //TODO:
    }



    @Override
    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        //TODO:
    }
    
}
