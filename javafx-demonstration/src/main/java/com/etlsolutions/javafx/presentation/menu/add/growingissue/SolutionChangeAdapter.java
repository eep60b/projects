
package com.etlsolutions.javafx.presentation.menu.add.growingissue;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author zc
 */
public class SolutionChangeAdapter implements ChangeListener<String> {

    private final AddGrowingIssueDataModel model;

    public SolutionChangeAdapter(AddGrowingIssueDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        model.setSolution(newValue);
    }
}