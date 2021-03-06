package com.etlsolutions.javafx.presentation.view.tree;

import com.etlsolutions.gwise.presentation.ExtendedDataFormat;
import com.etlsolutions.gwise.presentation.view.tree.GwiseTreeCellImpl;
import javafx.event.EventHandler;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;

/**
 *
 * @author zc
 */
public class TreeCellDragDetectedEventHandler implements EventHandler<MouseEvent> {

    public TreeCellDragDetectedEventHandler() {
    }

    @Override
    public void handle(MouseEvent event) {
        GwiseTreeCellImpl cell = (GwiseTreeCellImpl) event.getSource();
        cell.startDragAndDrop(TransferMode.COPY);
        ClipboardContent content = new ClipboardContent();
        content.put(ExtendedDataFormat.DATA_UNIT, cell.getItem());
    }
}
