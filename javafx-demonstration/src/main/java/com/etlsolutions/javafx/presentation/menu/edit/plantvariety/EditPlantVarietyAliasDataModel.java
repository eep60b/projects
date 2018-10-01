package com.etlsolutions.javafx.presentation.menu.edit.plantvariety;

import com.etlsolutions.javafx.presentation.Savable;
import com.etlsolutions.javafx.presentation.TitleDataModel;
import com.etlsolutions.javafx.presentation.Validatable;
import com.etlsolutions.javafx.presentation.menu.add.plantvariety.AddVarietyDialogDataModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author zc
 */
public class EditPlantVarietyAliasDataModel implements TitleDataModel, Savable, Validatable {

    public static final String TITLE_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.plantvariety. VarietyAliasDataModel.TITLE_PROPERTY";

    private final AddVarietyDialogDataModel parentModel;
    private String title;
    private final String oldTitle;

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public EditPlantVarietyAliasDataModel(AddVarietyDialogDataModel parentModel) {
        this.parentModel = parentModel;
        oldTitle = title = parentModel.getSelectedAlias();
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        String oldValue = this.title;
        this.title = title;
        support.firePropertyChange(TITLE_PROPERTY, oldValue, this.title);
    }

    public void addPropertyChangeListener(String property, PropertyChangeListener listener) {
        support.addPropertyChangeListener(property, listener);
    }

    @Override
    public void save() {

        if (oldTitle == null || oldTitle.trim().isEmpty()) {
            parentModel.addAlias(title);
        } else {
            parentModel.replaceAlias(oldTitle, title);
        }

    }

    @Override
    public boolean isValid() {
        return title != null && !title.trim().isEmpty();
    }

    @Override
    public String getErrorMessage() {

        if (isValid()) {
            return "";
        }

        return "Please enter alias name.";
    }
}
