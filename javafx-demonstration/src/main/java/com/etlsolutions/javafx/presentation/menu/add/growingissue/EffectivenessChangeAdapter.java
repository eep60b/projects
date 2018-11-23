package com.etlsolutions.javafx.presentation.menu.add.growingissue;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author zc
 */
public class EffectivenessChangeAdapter implements ChangeListener<String> {

    private final AbstractGrowingIssueDataModel model;

    public EffectivenessChangeAdapter(AbstractGrowingIssueDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        model.setEffectiveness(newValue);
    }
}
