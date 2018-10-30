/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.javafx.presentation.menu.add.plants;

import com.etlsolutions.javafx.data.other.GrowingMedium;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.ComboBox;

/**
 *
 * @author zc
 */
public class GrowingMediumSelectionPropertyChangeDapter implements PropertyChangeListener {

    private final ComboBox<GrowingMedium> growingMediumCombobox;

    public GrowingMediumSelectionPropertyChangeDapter(ComboBox<GrowingMedium> growingMediumCombobox) {
        
        this.growingMediumCombobox = growingMediumCombobox;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        growingMediumCombobox.getSelectionModel().select(((AddPlantsDataModel) evt.getSource()).getSelectedGrowingMedium());
    }
    
}
