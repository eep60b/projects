package com.etlsolutions.javafx.presentation.dialog.adapter;

import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.ValueWrapper;
import javafx.collections.ListChangeListener;
import javafx.scene.control.ListView;

/**
 *
 * @author zc
 * @param <T>
 */
public class ListViewListChangeAdapter<T> implements ListChangeListener<T> {

    private final ObservableListWrapperA<T> list;
    private final ListView<T> listView;
    private final ValueWrapper<T> valueWrpper;

    public ListViewListChangeAdapter(ObservableListWrapperA<T> list, ListView<T> listView, ValueWrapper<T> valueWrpper) {
        this.list = list;
        this.listView = listView;
        this.valueWrpper = valueWrpper;
    }

    @Override
    public void onChanged(ListChangeListener.Change<? extends T> c) {
        listView.setItems(list);

        int index = list.indexOf(valueWrpper.getValue());
        if (list.isEmpty()) {
            listView.getSelectionModel().select(null);
            return;
        }
        if (index < 0) {
            listView.getSelectionModel().select(0);
            return;
        }
        listView.getSelectionModel().select(index);
    }
}