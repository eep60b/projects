package com.etlsolutions.javafx.presentation.menu.add.plants;

import com.etlsolutions.javafx.data.plant.PlantVariety;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import com.etlsolutions.javafx.presentation.Validatable;
import com.etlsolutions.javafx.presentation.menu.add.plantvariety.VarietyAddable;

/**
 *
 * @author zc
 */
public class AddVarityToPlantsDialogDataModel extends DataUnitFXMLDataModel implements Validatable,VarietyAddable {

    private final AddPlantsDataModel model;

    public AddVarityToPlantsDialogDataModel(AddPlantsDataModel model) {
        this.model = model;
    }

    @Override
    public boolean addVariety(PlantVariety variety) {
        return model.addPlantVariety(variety);
    }  

    @Override
    protected void validate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getFxmlPath() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
