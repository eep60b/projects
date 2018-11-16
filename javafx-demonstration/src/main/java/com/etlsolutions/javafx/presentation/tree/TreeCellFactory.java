package com.etlsolutions.javafx.presentation.tree;

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
    public TreeCell<DataUnit> call(TreeView<DataUnit> p) {
        return new TreeCellImpl();
    }
}
