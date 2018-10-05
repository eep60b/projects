package com.etlsolutions.javafx.presentation.menu.add.growingmedium;

import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import com.etlsolutions.javafx.presentation.Savable;
import com.etlsolutions.javafx.presentation.Validatable;
import com.etlsolutions.javafx.presentation.menu.add.plants.AddPlantsDataModel;

/**
 *
 * @author zc
 */
public class AddGrowingMediumDataModel extends DataUnitFXMLDataModel implements Savable, Validatable {

    private final AddPlantsDataModel addPlantsDataModel;

    public AddGrowingMediumDataModel(AddPlantsDataModel model) {
        this.addPlantsDataModel = model;
    }

    @Override
    protected void validate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/menu/add/AddPlantVarietyDialogFXML.fxml";
    }
}
