package com.etlsolutions.javafx.presentation.menu.add.location;

import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public class AddLocationDataModel extends DataUnitFXMLDataModel {
    
    private ObservableList<Area> areas;
    private Area selectedArea;
    private ObservableList<SubArea> subAreas;
    private SubArea selectedSubArea;

    @Override
    public void add() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/menu/add/AddGventFXML.fxml";
    }
    
}
