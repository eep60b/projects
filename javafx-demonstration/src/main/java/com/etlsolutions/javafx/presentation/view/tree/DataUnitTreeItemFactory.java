package com.etlsolutions.javafx.presentation.view.tree;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.area.subarea.location.Location;
import com.etlsolutions.javafx.data.log.Log;
import com.etlsolutions.javafx.data.log.LogGroup;
import com.etlsolutions.javafx.data.log.LogMonth;
import com.etlsolutions.javafx.data.log.LogYear;
import com.etlsolutions.javafx.data.plant.PlantGroup;
import com.etlsolutions.javafx.data.plant.PlantSubGroup;
import com.etlsolutions.javafx.data.plant.Plants;
import com.etlsolutions.javafx.presentation.view.tree.area.AreaTreeItem;
import com.etlsolutions.javafx.presentation.view.tree.area.LocationTreeItem;
import com.etlsolutions.javafx.presentation.view.tree.area.SubAreaTreeItem;
import com.etlsolutions.javafx.presentation.view.tree.log.LogGroupTreeItem;
import com.etlsolutions.javafx.presentation.view.tree.log.LogMonthTreeItem;
import com.etlsolutions.javafx.presentation.view.tree.log.LogTreeItem;
import com.etlsolutions.javafx.presentation.view.tree.log.LogYearTreeItem;
import com.etlsolutions.javafx.presentation.view.tree.plant.PlantSubGroupTreeItem;
import com.etlsolutions.javafx.presentation.view.tree.plant.PlantGroupItem;
import com.etlsolutions.javafx.presentation.view.tree.plant.PlantsTreeItem;

/**
 *
 * @author zc
 */
public class DataUnitTreeItemFactory {

    private static final DataUnitTreeItemFactory INSTANCE = new DataUnitTreeItemFactory();

    private DataUnitTreeItemFactory() {
    }
    
    public static DataUnitTreeItemFactory getInstance() {
        return INSTANCE;
    }
    
    @SuppressWarnings("null")
    public MenuedTreeItem getTreeItem(DataUnit unit) {
        
        if(unit instanceof PlantGroup) {
            return new PlantGroupItem((PlantGroup) unit);
        }
        
        if(unit instanceof PlantSubGroup) {
            return new PlantSubGroupTreeItem((PlantSubGroup) unit);
        }
        
        if(unit instanceof Plants) {
            return new PlantsTreeItem((Plants) unit);
        }
        
        if(unit instanceof Area) {
            return new AreaTreeItem((Area)unit);
        }
        
        if(unit instanceof SubArea) {
            return new SubAreaTreeItem((SubArea) unit);
        }
        
        if(unit instanceof Location) {
            return new LocationTreeItem((Location)unit);
        }
       
        if(unit instanceof LogGroup) {
            return new LogGroupTreeItem((LogGroup) unit);
        }
        
        if(unit instanceof LogYear) {
            return new LogYearTreeItem((LogYear) unit);
        }
        
        if(unit instanceof LogMonth) {
            return new LogMonthTreeItem((LogMonth) unit);
        }
        
        if(unit instanceof Log) {
            return new LogTreeItem((Log) unit);
        }
        
        throw new IllegalArgumentException("Invalid data unit type: " + unit.getClass().getName());
    }
}
