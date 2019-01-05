package com.etlsolutions.javafx.presentation.tree;

import com.etlsolutions.javafx.data.DataUnit;
import java.util.List;
import java.util.Objects;
import javafx.collections.ListChangeListener;
import javafx.scene.control.TreeItem;

/**
 *
 * @author zc
 * @param <T>
 */
public class DataUnitListChangeAdapter<T extends DataUnit> implements ListChangeListener<T> {

    private final List<TreeItem<DataUnit>> children;

    public DataUnitListChangeAdapter(List<TreeItem<DataUnit>> children) {
        this.children = children;
    }

    @Override
    public void onChanged(Change<? extends T> c) {

        while(c.next()) {
            for (T item : c.getAddedSubList()) {
                children.add(DataUnitTreeItemFactory.getInstance().getTreeItem(item));
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
