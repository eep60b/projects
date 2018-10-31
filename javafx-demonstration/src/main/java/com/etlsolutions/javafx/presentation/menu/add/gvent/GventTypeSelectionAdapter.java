package com.etlsolutions.javafx.presentation.menu.add.gvent;

import com.etlsolutions.javafx.data.log.gvent.GventType;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author Zhipeng
 */
public class GventTypeSelectionAdapter implements ChangeListener<GventType> {

    private final AbstractGventDataModel model;

    public GventTypeSelectionAdapter(AbstractGventDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends GventType> observable, GventType oldValue, GventType newValue) {
        model.setSelectedType(newValue);
    }
    
}
