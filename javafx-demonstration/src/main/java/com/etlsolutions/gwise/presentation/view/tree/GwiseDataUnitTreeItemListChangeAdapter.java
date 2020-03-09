package com.etlsolutions.gwise.presentation.view.tree;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import java.util.List;
import java.util.Objects;
import javafx.collections.ListChangeListener;
import javafx.scene.control.TreeItem;

/**
 * The GwiseDataUnitTreeItemListChangeAdapter class listens to the children list
 * of a item and update the tree accordingly.
 *
 * @author zc
 * @param <T>
 */
public class GwiseDataUnitTreeItemListChangeAdapter<T extends GwiseDataUnit> implements ListChangeListener<T> {

    private final List<TreeItem<GwiseDataUnit>> children;

    public GwiseDataUnitTreeItemListChangeAdapter(List<TreeItem<GwiseDataUnit>> children) {
        this.children = children;
    }

    @Override
    public void onChanged(Change<? extends T> c) {

        while (c.next()) {
            for (T item : c.getAddedSubList()) {
                children.add(GwiseDataUnitTreeItemFactory.getInstance().getTreeItem(item));
            }

            for (T t : c.getRemoved()) {

                for (int i = children.size() - 1; i >= 0; i--) {

                    if (Objects.equals(t, children.get(i).getValue())) {
                        children.remove(i);
                    }
                }
            }
        }
    }

}
