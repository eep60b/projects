package com.etlsolutions.javafx.presentation.log.gvent;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.log.gvent.GventType;
import com.etlsolutions.javafx.presentation.NodeGenerator;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

/**
 *
 * @author Zhipeng
 */
public class SelectedTypePropertyAdapter implements PropertyChangeListener {

    private final AbstractGventDataModel model;
    private final TabPane mainTabPane;
    private final Tab detailTab;
    private final NodeGenerator generator;

    public SelectedTypePropertyAdapter(AbstractGventDataModel model, TabPane mainTabPane, Tab detailTab, NodeGenerator<AbstractGventDataModel, GventType> generator) {
        this.model = model;
        this.mainTabPane = mainTabPane;
        this.detailTab = detailTab;
        this.generator = generator;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        process((ValueWrapper<GventType>) evt.getSource());
    }

    public void process(ValueWrapper<GventType> wrapper) throws IllegalArgumentException {
        GventType type = wrapper.getValue();
        model.setContentModel(model.getDetailDataModel(type));        
        switch (type) {
            case CUSTOM:
                mainTabPane.getTabs().remove(detailTab);
                return;
            case FLOWERING:
            case FRUITING:
                if (!mainTabPane.getTabs().contains(detailTab)) {
                    mainTabPane.getTabs().add(1, detailTab);
                }
                detailTab.setContent(generator.getNode(type));
                return;
            default:
                throw new IllegalArgumentException("Ivalid gvent type.");
        }
    }

}
