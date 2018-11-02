package com.etlsolutions.javafx.presentation.menu.add.gvent;

import com.etlsolutions.javafx.data.log.gvent.GventType;
import com.etlsolutions.javafx.presentation.ComponentsFXMLControllerNodeWrapper;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Map;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

/**
 *
 * @author Zhipeng
 */
public class SelectedTypePropertyAdapter implements PropertyChangeListener {

    private final TabPane mainTabPane;
    private final Tab detailTab;
    private final Map<GventType, ComponentsFXMLControllerNodeWrapper<GventDetailDataModel>> map;

    public SelectedTypePropertyAdapter(TabPane mainTabPane, Tab detailTab, Map<GventType, ComponentsFXMLControllerNodeWrapper<GventDetailDataModel>> map) {
        this.mainTabPane = mainTabPane;
        this.detailTab = detailTab;
        this.map = map;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        AbstractGventDataModel model = (AbstractGventDataModel) evt.getSource();
        GventType type = model.getSelectedType();        
        model.setDetailDataModel(map.get(type).getController().getModel());
   
        switch (type) {
            case CUSTOM:
                mainTabPane.getTabs().remove(detailTab);
                return;
            case FLOWERING:
            case FRUITING:
                if (!mainTabPane.getTabs().contains(detailTab)) {
                    mainTabPane.getTabs().add(1, detailTab);
                }
                detailTab.setContent(map.get(type).getNode());
                return;
            default:
                throw new IllegalArgumentException("Ivalid gvent type.");
        }
    }

}
