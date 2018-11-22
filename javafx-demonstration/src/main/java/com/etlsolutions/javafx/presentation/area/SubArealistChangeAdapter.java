package com.etlsolutions.javafx.presentation.area;

import com.etlsolutions.javafx.data.area.subarea.SubArea;
import javafx.collections.ListChangeListener;
import javafx.scene.control.ListView;

/**
 *
 * @author zc
 */
public class SubArealistChangeAdapter implements ListChangeListener<SubArea>{

    private final AbstractAreaDataModel model;
    private final ListView subAreaListView;

    public SubArealistChangeAdapter(AbstractAreaDataModel model, ListView subAreaListView) {
        
        this.model = model;
        this.subAreaListView = subAreaListView;
    }

    @Override
    public void onChanged(Change<? extends SubArea> c) {

        subAreaListView.setItems(model.getSubAreas());        
    }
}
