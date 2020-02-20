package com.etlsolutions.javafx.presentation.dialog.log.task;

import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.javafx.data.log.task.TaskType;
import com.etlsolutions.gwise.presentation.FXMLActionDataModel;
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

    private final AbstractTaskDataModel model;
    private final TabPane mainTabPane;
    private final Tab detailTab;
    private final NodeGenerator generator;

    public SelectedTypePropertyAdapter(AbstractTaskDataModel model, TabPane mainTabPane, Tab detailTab, NodeGenerator<AbstractTaskDataModel, TaskType> generator) {
        this.model = model;
        this.mainTabPane = mainTabPane;
        this.detailTab = detailTab;
        this.generator = generator;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        process((ValueWrapper<TaskType>) evt.getSource());
    }

    public void process(ValueWrapper<TaskType> wrapper) throws IllegalArgumentException {

        TaskType type = wrapper.getValue(); 
        switch (type) {
            case CUSTOM:
                mainTabPane.getTabs().remove(detailTab);
                return;
            case FERTILZATION:
            case HARVESTING:
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
