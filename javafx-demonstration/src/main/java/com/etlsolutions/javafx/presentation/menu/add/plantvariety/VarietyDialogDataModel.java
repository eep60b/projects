package com.etlsolutions.javafx.presentation.menu.add.plantvariety;

import com.etlsolutions.javafx.presentation.DataUnitDataModel;
import com.etlsolutions.javafx.presentation.menu.add.planttype.PlantTypeDialogDataModel;
import com.sun.javafx.collections.ObservableListWrapper;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public class VarietyDialogDataModel extends DataUnitDataModel {

    public static final String LATIN_NAME_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.plantvariety.VarietyDialogDataModel.LATIN_NAME_PROPERTY";
    public static final String ALIASES_PROPERTY = "com.etlsolutions.javafx.presentation.DataUnitDataModel.VarietyDialogDataModel.ALIASES_PROPERTY";
    public static final String SELECTED_ALIAS_PROPERTY = "com.etlsolutions.javafx.presentation.DataUnitDataModel.VarietyDialogDataModel.SELECTED_ALIAS_PROPERTY";
    
    private final PlantTypeDialogDataModel parentModel;
    private String latinName;
    private ObservableList<String> aliases;
    private String selectedAlias;

    public VarietyDialogDataModel(PlantTypeDialogDataModel parentModel) {
        this.parentModel = parentModel;
        aliases = new ObservableListWrapper<>(new ArrayList<String>());
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

    public void setAliases(List<String> aliases) {
        this.aliases = new ObservableListWrapper<>(aliases);
        support.firePropertyChange(ALIASES_PROPERTY, false, true);
    }    
    
    public boolean addAlias(String alias) {
        boolean added = aliases.add(alias);
        support.firePropertyChange(ALIASES_PROPERTY, false, added);
        return added;
    } 
    
    public boolean removeAliase(String aliase) {
        boolean removed = aliases.remove(aliase);
        support.firePropertyChange(ALIASES_PROPERTY, false, removed);
        return removed;
    }

    public String getSelectedAlias() {
        return selectedAlias;
    }

    public void setSelectedAlias(String selectedAlias) {
        String oldValue = this.selectedAlias;
        this.selectedAlias = selectedAlias;
        support.firePropertyChange(SELECTED_ALIAS_PROPERTY, oldValue, this.selectedAlias);
    }
}
