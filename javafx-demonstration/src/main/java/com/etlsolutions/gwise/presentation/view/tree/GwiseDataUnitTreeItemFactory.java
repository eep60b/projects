package com.etlsolutions.gwise.presentation.view.tree;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import com.etlsolutions.gwise.data.area.GwiseArea;
import com.etlsolutions.gwise.data.locations.GwiseLocationSet;
import com.etlsolutions.gwise.data.log.GwiseLog;
import com.etlsolutions.gwise.data.log.GwiseLogGroup;
import com.etlsolutions.gwise.data.log.GwiseLogMonth;
import com.etlsolutions.gwise.data.log.GwiseLogYear;
import com.etlsolutions.gwise.data.plant.GwiseLocationPlantSet;
import com.etlsolutions.gwise.data.plant.GwisePlantGroup;
import com.etlsolutions.gwise.data.plant.GwisePlantSubgroup;
import com.etlsolutions.gwise.data.subarea.GwiseSubarea;
import com.etlsolutions.gwise.presentation.view.tree.area.GwiseAreaTreeItem;
import com.etlsolutions.gwise.presentation.view.tree.area.GwiseSubareaTreeItem;
import com.etlsolutions.gwise.presentation.view.tree.area.LocationSetTreeItem;
import com.etlsolutions.gwise.presentation.view.tree.log.GwiseLogGroupTreeItem;
import com.etlsolutions.gwise.presentation.view.tree.log.GwiseLogMonthTreeItem;
import com.etlsolutions.gwise.presentation.view.tree.log.GwiseLogTreeItem;
import com.etlsolutions.gwise.presentation.view.tree.log.GwiseLogYearTreeItem;
import com.etlsolutions.gwise.presentation.view.tree.plant.GwisePlantGroupItem;
import com.etlsolutions.gwise.presentation.view.tree.plant.GwisePlantSubgroupTreeItem;
import com.etlsolutions.gwise.presentation.view.tree.plant.LocationPlantSetTreeItem;

/**
 *
 * @author zc
 */
public class GwiseDataUnitTreeItemFactory {

    private static final GwiseDataUnitTreeItemFactory INSTANCE = new GwiseDataUnitTreeItemFactory();

    private GwiseDataUnitTreeItemFactory() {
    }
    
    public static GwiseDataUnitTreeItemFactory getInstance() {
        return INSTANCE;
    }
    
    @SuppressWarnings("null")
    public GwiseMenuedTreeItem getTreeItem(GwiseDataUnit unit) {
        
        if(unit instanceof GwisePlantGroup) {
            return new GwisePlantGroupItem((GwisePlantGroup) unit);
        }
        
        if(unit instanceof GwisePlantSubgroup) {
            return new GwisePlantSubgroupTreeItem((GwisePlantSubgroup) unit);
        }
        
        if(unit instanceof GwiseLocationPlantSet) {
            return new LocationPlantSetTreeItem((GwiseLocationPlantSet) unit);
        }
        
        if(unit instanceof GwiseArea) {
            return new GwiseAreaTreeItem((GwiseArea)unit);
        }
        
        if(unit instanceof GwiseSubarea) {
            return new GwiseSubareaTreeItem((GwiseSubarea) unit);
        }
        
        if(unit instanceof GwiseLocationSet) {
            return new LocationSetTreeItem((GwiseLocationSet)unit);
        }
       
        if(unit instanceof GwiseLogGroup) {
            return new GwiseLogGroupTreeItem((GwiseLogGroup) unit);
        }
        
        if(unit instanceof GwiseLogYear) {
            return new GwiseLogYearTreeItem((GwiseLogYear) unit);
        }
        
        if(unit instanceof GwiseLogMonth) {
            return new GwiseLogMonthTreeItem((GwiseLogMonth) unit);
        }
        
        if(unit instanceof GwiseLog) {
            return new GwiseLogTreeItem((GwiseLog) unit);
        }
        
        throw new IllegalArgumentException("Invalid data unit type: " + unit.getClass().getName());
    }
}
