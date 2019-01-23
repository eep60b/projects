package com.etlsolutions.javafx.presentation.dialog.log.gvent;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.log.gvent.GventType;
import com.etlsolutions.javafx.presentation.NodeGenerator;
import com.etlsolutions.javafx.presentation.DetailDataModelGenerator;
import com.etlsolutions.javafx.presentation.FXMLActionDataModel;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

/**
 *
 * @author Zhipeng
 */
public class SelectedGventTypePropertyAdapter implements PropertyChangeListener {

    private final AbstractGventDataModel model;
    private final TabPane mainTabPane;
    private final Tab detailTab;
    private final NodeGenerator generator;

    public SelectedGventTypePropertyAdapter(AbstractGventDataModel model, TabPane mainTabPane, Tab detailTab, NodeGenerator<AbstractGventDataModel, GventType> generator) {
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
        model.setContentModel(DetailDataModelGenerator.getInstance().getDetailDataModel(type));        
        switch (type) {
            case CUSTOM:
                mainTabPane.getTabs().remove(detailTab);
                return;
            case FLOWERING:
            case FRUITING:
                if (!mainTabPane.getTabs().contains(detailTab)) {
                    mainTabPane.getTabs().add(1, detailTab);
                }
                detailTab.setContent(generator.getNode(type).getNode());
                model.setContentModel((FXMLActionDataModel)generator.getNode(type).getModel());                
                return;
            default:
                throw new IllegalArgumentException("Ivalid gvent type.");
        }
    }

}
