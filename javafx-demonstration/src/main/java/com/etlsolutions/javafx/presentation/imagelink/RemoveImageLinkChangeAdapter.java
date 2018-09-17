package com.etlsolutions.javafx.presentation.imagelink;

import com.etlsolutions.javafx.data.ImageLink;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.SelectionModel;

/**
 *
 * @author zc
 */
public class RemoveImageLinkChangeAdapter implements ChangeListener<SelectionModel<ImageLink>>{

    private final ImageLinkDataModel model;

    public RemoveImageLinkChangeAdapter(ImageLinkDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends SelectionModel<ImageLink>> observable, SelectionModel<ImageLink> oldValue, SelectionModel<ImageLink> newValue) {
        model.remove(newValue.getSelectedItem());
    }
}
