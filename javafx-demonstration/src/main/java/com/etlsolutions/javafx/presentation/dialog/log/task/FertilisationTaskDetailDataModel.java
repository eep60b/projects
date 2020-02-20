package com.etlsolutions.javafx.presentation.dialog.log.task;

import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.javafx.data.log.task.FertilisationTaskValueWrapper;
import com.etlsolutions.javafx.data.other.Fertiliser;
import com.etlsolutions.javafx.presentation.RemoveEventId;
import com.etlsolutions.javafx.system.ProjectManager;
import java.util.Objects;

/**
 *
 * @author Zhipeng
 */
public class FertilisationTaskDetailDataModel extends TaskDetailDataModel<FertilisationTaskValueWrapper> {

    public static final RemoveEventId FERTILISER_REMOVE_EVENT_ID = new RemoveEventId(AbstractTaskDataModel.class.getName() + "FERTILISER_REMOVE_EVENT_ID", "remove fertiliser");

    private final ObservableListWrapperA<Fertiliser> fertilisers;
    private final ObservableListWrapperA<String> uoms;

    public FertilisationTaskDetailDataModel(FertilisationTaskValueWrapper fertilisationTaskDetail) {

        super(fertilisationTaskDetail);
        fertilisers = new ObservableListWrapperA<>(ProjectManager.getInstance().getContents().getFertilisers());
        uoms = new ObservableListWrapperA<>(ProjectManager.getInstance().getContents().getFertiliserUoms());
    }

    public ObservableListWrapperA<Fertiliser> getFertilisers() {
        return fertilisers;
    }

    public ValueWrapper<Fertiliser> getSelectedFertiliser() {
        return detail.getFertiliserValueWrapper();
    }

    public ValueWrapper<String> getAmount() {
        return detail.getAmountValueWrapper();
    }

    public ObservableListWrapperA<String> getUoms() {
        return uoms;
    }

    public ValueWrapper<String> getSelectedUom() {
        return detail.getUomValueWrapper();
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/log/FertilisationTaskFXML.fxml";
    }

    @Override
    public void remove(RemoveEventId id) {
        if (Objects.equals(id, FERTILISER_REMOVE_EVENT_ID)) {
            fertilisers.removeAndGetNext(detail.getFertiliserValueWrapper());
        }
    }

    @Override
    public void save() {
        ObservableListWrapperA<String> ums = ProjectManager.getInstance().getContents().getFertiliserUoms();
        String um = detail.getUomValueWrapper().getValue();
        if(ums.contains(um)) {
            return;
        }
        
        ums.add(um);
    }
}
