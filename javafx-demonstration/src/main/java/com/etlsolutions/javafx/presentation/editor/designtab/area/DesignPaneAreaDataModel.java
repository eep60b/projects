package com.etlsolutions.javafx.presentation.editor.designtab.area;

import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.area.subarea.SubAreaFactory;
import com.etlsolutions.javafx.data.area.subarea.SubAreaShape;
import com.etlsolutions.javafx.data.area.subarea.SubAreaType;
import com.etlsolutions.javafx.presentation.Itemable;
import com.etlsolutions.gwise.system.ProjectManager;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author ZhipengChang
 */
public class DesignPaneAreaDataModel implements Itemable<Area> {

    private final Area item;
    public static final String SUBAREA_DROPPED_PROPERTY = DesignPaneAreaDataModel.class.getName() + ".SUBAREA_DROPPED_PROPERTY";

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    
    public DesignPaneAreaDataModel(Area area) {
        item = area;
    }

    @Override
    public Area getItem() {
        return item;
    }

    public void drop(SubAreaType type, SubAreaShape shape) {
        
        SubArea subArea = SubAreaFactory.getInstance().createDefaultPlantBed();
        
        item.getSubAreas().add(subArea);
        ProjectManager.getInstance().addItem(subArea);
        ProjectManager.getInstance().getSelectedDataUnitValueWrapper().setValue(subArea);
        support.firePropertyChange(SUBAREA_DROPPED_PROPERTY, true, false);
    }
    

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(propertyName, listener);
    }

    public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(propertyName, listener);
    }

    public boolean hasListeners(String propertyName) {
        return support.hasListeners(propertyName);
    }       
}
