/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.javafx.presentation.menu.add.location;

import com.etlsolutions.javafx.data.area.subarea.SubAreaType;
import com.sun.javafx.collections.ObservableListWrapper;
import java.util.Arrays;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public class AddLocationdataModel {
    
    
    private final ObservableList<SubAreaType> types;
    private SubAreaType selectedType;

    public AddLocationdataModel() {
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
    
    
    
}
