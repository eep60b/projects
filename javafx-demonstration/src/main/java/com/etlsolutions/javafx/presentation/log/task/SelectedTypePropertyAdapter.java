package com.etlsolutions.javafx.presentation.log.task;

import com.etlsolutions.javafx.data.log.task.TaskType;
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

    private final TabPane mainTabPane;
    private final Tab detailTab;
    private final NodeGenerator generator;

    public SelectedTypePropertyAdapter(TabPane mainTabPane, Tab detailTab, NodeGenerator<AbstractTaskDataModel, TaskType> generator) {
        this.mainTabPane = mainTabPane;
        this.detailTab = detailTab;
        this.generator = generator;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        AbstractTaskDataModel model = (AbstractTaskDataModel) evt.getSource();
        TaskType type = model.getSelectedTypeValueWrapper().getValue(); 
        model.setContentModel(model.getDetailDataModel(type));
        switch (type) {
            case CUSTOM:
                mainTabPane.getTabs().remove(detailTab);
                return;
            case FERTILZATION:
            case HARVESTING:
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