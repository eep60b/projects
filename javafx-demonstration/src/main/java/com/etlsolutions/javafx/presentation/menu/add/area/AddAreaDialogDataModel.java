package com.etlsolutions.javafx.presentation.menu.add.area;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.data.area.AreaFactory;
import com.etlsolutions.javafx.data.area.AreaType;
import com.etlsolutions.javafx.presentation.DataUnitDataModel;
import com.etlsolutions.javafx.presentation.Validatable;
import com.etlsolutions.javafx.system.ProjectManager;
import java.util.Arrays;
import javafx.collections.ObservableList;

/**
 *
 * @author Zhipeng
 */
public class AddAreaDialogDataModel extends DataUnitDataModel implements Validatable {

    private final ObservableList<AreaType> areaTypes;
    private AreaType selectedAreaType;
    
    public AddAreaDialogDataModel() {
        this.areaTypes = new ObservableListWrapperA<>(Arrays.asList(AreaType.values()));
        selectedAreaType = areaTypes.get(0);
    }

    public ObservableList<AreaType> getAreaTypes() {
        return areaTypes;
    }

    public AreaType getSelectedAreaType() {
        return selectedAreaType;
    }

    public void setSelectedAreaType(AreaType selectedAreaType) {
        this.selectedAreaType = selectedAreaType;
    }

    @Override
    protected void validate() {
        
        valid = title != null && !title.isEmpty();
        if(!valid) {
            errorMessage = "Enter the title";
        }
    }

    @Override
    public void save() {
        Area a = AreaFactory.createArea(selectedAreaType, title, information, imageLinks);
        ProjectManager.getInstance().getProject().getAreaRoot().getAllAreas().add(a);
    }
}
