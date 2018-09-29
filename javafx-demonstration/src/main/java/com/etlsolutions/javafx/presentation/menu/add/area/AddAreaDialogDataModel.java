package com.etlsolutions.javafx.presentation.menu.add.area;

import com.etlsolutions.javafx.data.area.AreaType;
import com.etlsolutions.javafx.presentation.Closable;
import com.etlsolutions.javafx.presentation.DataUnitDataModel;
import com.etlsolutions.javafx.presentation.Savable;
import com.etlsolutions.javafx.presentation.Validatable;
import com.sun.javafx.collections.ObservableListWrapper;
import java.util.Arrays;
import javafx.collections.ObservableList;

/**
 *
 * @author Zhipeng
 */
public class AddAreaDialogDataModel extends DataUnitDataModel implements Savable, Validatable, Closable {

    private final ObservableList<AreaType> areaTypes;
    private AreaType selectedAreaType;
    
    public AddAreaDialogDataModel() {
        this.areaTypes = new ObservableListWrapper<>(Arrays.asList(AreaType.values()));
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
        String title = getTitle();
        valid = title != null && !title.isEmpty();
        if(!valid) {
            errorMessage = "Enter the title";
        }
    }

    @Override
    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
