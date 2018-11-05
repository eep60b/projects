package com.etlsolutions.javafx.presentation.log.task;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.log.task.FertilisationTaskDetail;
import com.etlsolutions.javafx.data.other.Fertiliser;
import com.etlsolutions.javafx.presentation.RemoveEventId;
import com.etlsolutions.javafx.system.ProjectManager;
import java.util.Objects;

/**
 *
 * @author Zhipeng
 */
public class FertilizationTaskDetailDataModel extends TaskDetailDataModel<FertilisationTaskDetail> {

    public static final RemoveEventId FERTILISER_REMOVE_EVENT_ID = new RemoveEventId(AbstractTaskDataModel.class.getName() + "FERTILISER_REMOVE_EVENT_ID", "remove fertiliser");

    private final ObservableListWrapperA<Fertiliser> fertilisers;
    private final ObservableListWrapperA<String> uoms;

    public FertilizationTaskDetailDataModel(FertilisationTaskDetail fertilisationTaskDetail) {

        super(fertilisationTaskDetail);
        fertilisers = new ObservableListWrapperA<>(ProjectManager.getInstance().getProject().getFertilisers());
        uoms = new ObservableListWrapperA<>(ProjectManager.getInstance().getProject().getFertiliserUoms());
    }

    public ObservableListWrapperA<Fertiliser> getFertilisers() {
        return fertilisers;
    }

    public ValueWrapper<Fertiliser> getSelectedFertiliser() {
        return detail.getFertiliser();
    }

    public ValueWrapper<String> getAmount() {
        return detail.getAmount();
    }

    public ObservableListWrapperA<String> getUoms() {
        return uoms;
    }

    public ValueWrapper<String> getSelectedUom() {
        return detail.getUom();
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/log/FertilisationTaskFXML.fxml";
    }

    @Override
    public void remove(RemoveEventId id) {
        if (Objects.equals(id, FERTILISER_REMOVE_EVENT_ID)) {
            
            int index = fertilisers.indexOf(detail.getFertiliser());
            fertilisers.remove(index);
            index = index == fertilisers.size() ? index - 1 : index;
            detail.getFertiliser().setValue(fertilisers.get(index));
        }
    }
}
