package com.etlsolutions.javafx.presentation.menu.add.location;

import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.data.area.subarea.SubAreaK;
import com.etlsolutions.javafx.system.ProjectManager;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public class TypeSelectionDataModel {

    private final AddLocationWizardDataModel parent;
    private final ObservableList<Area> areas;
    private Area selectedArea;
    private ObservableList<SubAreaK> subAreas;
    private SubAreaK selectedSubArea;

    public TypeSelectionDataModel(AddLocationWizardDataModel parent) {
        this.parent = parent;
        areas = ProjectManager.getInstance().getProject().getAreaRoot().getAllAreas();
        selectedArea = areas.get(0);
        subAreas = selectedArea.getAllSubAreas();
        if(!subAreas.isEmpty()) {
            selectedSubArea = subAreas.get(0);
        }
    }

    public ObservableList<Area> getAreas() {
        return areas;
    }
    
    public Area getSelectedArea() {
        return selectedArea;
    }

    public void setSelectedArea(Area selectedArea) {
        this.selectedArea = selectedArea;
        subAreas = selectedArea.getAllSubAreas();
        setSelectedSubArea(this.subAreas.isEmpty() ? null : subAreas.get(0));
    }

    public ObservableList<SubAreaK> getSubAreas() {
        return subAreas;
    }

    public void setSubAreas(ObservableList<SubAreaK> subAreas) {
        this.subAreas = subAreas;
    }

    public SubAreaK getSelectedSubArea() {
        return selectedSubArea;
    }

    public void setSelectedSubArea(SubAreaK selectedSubArea) {
        this.selectedSubArea = selectedSubArea;
        parent.setSelectedType(this.selectedArea == null ? null : this.selectedSubArea.getType());        
    }
}
