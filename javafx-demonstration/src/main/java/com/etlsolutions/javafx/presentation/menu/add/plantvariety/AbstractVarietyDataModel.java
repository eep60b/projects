package com.etlsolutions.javafx.presentation.menu.add.plantvariety;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.plant.PlantVariety;
import com.etlsolutions.javafx.data.plant.PlantsFactory;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public abstract class AbstractVarietyDataModel extends DataUnitFXMLDataModel<PlantVariety> {
    
    public static final String LATIN_NAME_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.plantvariety.VarietyDialogDataModel.LATIN_NAME_PROPERTY";
    public static final String ALIASES_PROPERTY = "com.etlsolutions.javafx.presentation.DataUnitDataModel.VarietyDialogDataModel.ALIASES_PROPERTY";
    public static final String SELECTED_ALIAS_PROPERTY = "com.etlsolutions.javafx.presentation.DataUnitDataModel.VarietyDialogDataModel.SELECTED_ALIAS_PROPERTY";
    
    protected String latinName;
    protected final ObservableListWrapperA<String> aliases;
    private String selectedAlias;
    
    public AbstractVarietyDataModel() {
        aliases = new ObservableListWrapperA<>();
    }

    public AbstractVarietyDataModel(PlantVariety variety) {
        this();
        this.dataUnit = variety;
    }
    
    
    
    public String getLatinName() {
        return latinName;
    }
    
    public void setLatinName(String latinName) {
        
        String oldValue = this.latinName;
        this.latinName = latinName;
        support.firePropertyChange(LATIN_NAME_PROPERTY, oldValue, this.latinName);
    }
    
    public ObservableList<String> getAliases() {
        return aliases;
    }
   
    public boolean addAlias(String alias) {
        boolean added = aliases.add(alias);
        support.firePropertyChange(ALIASES_PROPERTY, false, added);
        return added;
    }
    
    public String getSelectedAlias() {
        return selectedAlias;
    }
    
    public void setSelectedAlias(String selectedAlias) {
        String oldValue = this.selectedAlias;
        this.selectedAlias = selectedAlias;
        support.firePropertyChange(SELECTED_ALIAS_PROPERTY, oldValue, this.selectedAlias);
    }
    
    public boolean removeSelectedAlias() {
        
        int index = aliases.indexOf(selectedAlias);
        boolean removed = aliases.remove(selectedAlias);        
        support.firePropertyChange(ALIASES_PROPERTY, false, removed);
        if (index == aliases.size()) {
            index--;
        }
        selectedAlias = aliases.isEmpty() ? null : aliases.get(index);
        return removed;
    }
    
    @Override
    public void save() {
        dataUnit = PlantsFactory.getInstance().createPlantVariety(getTitle(), getLatinName(), getInformation(), getAliases(), getImageLinks());
    }
    
    @Override
    public String getFxmlPath() {
        return "/fxml/menu/add/PlantVarietyFXML.fxml";
    }
}