package com.etlsolutions.javafx.presentation.view.tree;

import com.etlsolutions.javafx.data.DataUnit;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeView;
import javafx.util.Callback;


/**
 *
 * @author zc
 */
public class TreeCellFactory implements Callback<TreeView<DataUnit>, TreeCell<DataUnit>> {

    @Override
    public TreeCellImpl call(TreeView<DataUnit> p) {
        
        TreeCellImpl cell = new TreeCellImpl();
        cell.setOnDragDetected(new TreeCellDragDetectedEventHandler());
        return cell;
    }
}
