package com.etlsolutions.javafx.presentation.adapter;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.ListView;

/**
 *
 * @author zc
 */
public class EditListViewPropertyChangeAdapter implements PropertyChangeListener {

    private final ListView listView;
    
    public EditListViewPropertyChangeAdapter(ListView listView) {
        this.listView = listView;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        
        listView.refresh();
    }
}
