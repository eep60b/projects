package com.etlsolutions.javafx.presentation.view.tree;

import com.etlsolutions.javafx.presentation.ExtendeeDataFormat;
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
        TreeCellImpl cell = (TreeCellImpl) event.getSource();
        cell.startDragAndDrop(TransferMode.COPY);
        ClipboardContent content = new ClipboardContent();
        content.put(ExtendeeDataFormat.DATA_UNIT, cell.getItem());
    }
}
