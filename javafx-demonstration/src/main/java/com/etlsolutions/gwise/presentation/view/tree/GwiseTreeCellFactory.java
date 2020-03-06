package com.etlsolutions.gwise.presentation.view.tree;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import com.etlsolutions.javafx.presentation.view.tree.TreeCellDragDetectedEventHandler;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeView;
import javafx.util.Callback;

/**
 * The GwiseTreeCellFactory class is a factory class which create tree cell for
 * displaying.
 *
 * @author zc
 */
public class GwiseTreeCellFactory implements Callback<TreeView<GwiseDataUnit>, TreeCell<GwiseDataUnit>> {

    @Override
    public GwiseTreeCellImpl call(TreeView<GwiseDataUnit> p) {

        GwiseTreeCellImpl cell = new GwiseTreeCellImpl();
        cell.setOnDragDetected(new TreeCellDragDetectedEventHandler());
        return cell;
    }
}
