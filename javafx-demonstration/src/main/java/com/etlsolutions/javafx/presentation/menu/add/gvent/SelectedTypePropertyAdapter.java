/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.javafx.presentation.menu.add.gvent;

import com.etlsolutions.javafx.data.log.gvent.GventType;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Map;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

/**
 *
 * @author Zhipeng
 */
public class SelectedTypePropertyAdapter implements PropertyChangeListener {

    private final TabPane mainTabPane;
    private final Tab detailTab;
    private final Map<GventType, Node> map;

    public SelectedTypePropertyAdapter(TabPane mainTabPane, Tab detailTab, Map<GventType, Node> map) {
        this.mainTabPane = mainTabPane;
        this.detailTab = detailTab;
        this.map = map;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        AbstractGventDataModel model = (AbstractGventDataModel) evt.getSource();
        GventType type = model.getSelectedType();
        switch (type) {
            case CUSTOM:
                mainTabPane.getTabs().remove(detailTab);
                return;
            case FLOWERING:
            case FRUITING:
                if (!mainTabPane.getTabs().contains(detailTab)) {
                    mainTabPane.getTabs().add(1, detailTab);
                }
                detailTab.setContent(map.get(type));
                return;
            default:
                throw new IllegalArgumentException("Ivalid gvent type.");
        }
    }

}
