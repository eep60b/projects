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
public class FertilisationTaskDetailDataModel extends TaskDetailDataModel<FertilisationTaskDetail> {

    public static final RemoveEventId FERTILISER_REMOVE_EVENT_ID = new RemoveEventId(AbstractTaskDataModel.class.getName() + "FERTILISER_REMOVE_EVENT_ID", "remove fertiliser");

    private final ObservableListWrapperA<Fertiliser> fertilisers;
    private final ObservableListWrapperA<String> uoms;

    public FertilisationTaskDetailDataModel(FertilisationTaskDetail fertilisationTaskDetail) {

        super(fertilisationTaskDetail);
        fertilisers = new ObservableListWrapperA<>(ProjectManager.getInstance().getContents().fertilisers());
        uoms = new ObservableListWrapperA<>(ProjectManager.getInstance().getContents().getFertiliserUoms());
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
            Fertiliser f = fertilisers.removeAndGetNext(detail.getFertiliser().getValue());
            detail.getFertiliser().setValue(f);
        }
    }

    @Override
    public void save() {
        ObservableListWrapperA<String> ums = ProjectManager.getInstance().getContents().getFertiliserUoms();
        String um = detail.getUom().getValue();
        if(ums.contains(um)) {
            return;
        }
        
        ums.add(um);
    }
}
