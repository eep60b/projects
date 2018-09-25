package com.etlsolutions.javafx.presentation.menu.add.location;

import com.etlsolutions.javafx.data.area.subarea.SubAreaType;
import com.etlsolutions.javafx.presentation.DataUnitDataModel;
import com.etlsolutions.javafx.presentation.wizard.StatusPropertyChangeAdapter;
import com.etlsolutions.javafx.presentation.wizard.WizardDataModel;
import com.sun.javafx.collections.ObservableListWrapper;
import java.util.Arrays;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public class AddLocationWizardDataModel extends DataUnitDataModel implements WizardDataModel {
    
    
    private final ObservableList<SubAreaType> types;
    private SubAreaType selectedType;
    private int currentIndex;

    public AddLocationWizardDataModel() {
        this.types = new ObservableListWrapper<>(Arrays.asList(SubAreaType.values()));
        selectedType = types.get(0);
    }

    public ObservableList<SubAreaType> getTypes() {
        return types;
    }

    public SubAreaType getSelectedType() {
        return selectedType;
    }

    public void setSelectedType(SubAreaType selectedType) {
        this.selectedType = selectedType;
    }

    @Override
    public String getPageTitle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean notToPrevious() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addPropertyChangeListener(String NAVIGATE_TO_PREVIOUS_PROPERTY, StatusPropertyChangeAdapter navigateToPreviousPropertyChangeAdapter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean notToNext() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean canNotFinish() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCurrentIndex(int newPageIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCurrentIndex() {
        return currentIndex;
    }

    @Override
    public String getErrorMessage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void validate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
