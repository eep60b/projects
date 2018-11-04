package com.etlsolutions.javafx.presentation.log.task;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.log.task.FertilisationTaskDetail;
import com.etlsolutions.javafx.data.other.Fertiliser;
import com.etlsolutions.javafx.system.ProjectManager;

/**
 *
 * @author Zhipeng
 */
public class FertilizationTaskDetailDataModel extends TaskDetailDataModel<FertilisationTaskDetail> {

    private final ObservableListWrapperA<Fertiliser> fertilisers;
    private final ValueWrapper<Fertiliser> selectedFertiliser;
    private final ValueWrapper<Double> amount;
    private final ObservableListWrapperA<String> uoms;
    private final ValueWrapper<String> selectedUom;
    
    public FertilizationTaskDetailDataModel(FertilisationTaskDetail fertilisationTaskDetail) {
        
        super(fertilisationTaskDetail);
        fertilisers = new ObservableListWrapperA<>(ProjectManager.getInstance().getProject().getFertilisers());
        selectedFertiliser = fertilisationTaskDetail.getFertiliser();
        amount = fertilisationTaskDetail.getAmount();
        uoms = new ObservableListWrapperA<>(ProjectManager.getInstance().getProject().getFertiliserUoms());
        selectedUom = fertilisationTaskDetail.getUom();
    }

    public ObservableListWrapperA<Fertiliser> getFertilisers() {
        return fertilisers;
    }

    public Fertiliser getSelectedFertiliser() {
        return selectedFertiliser.getValue();
    }

    public void setSelectedFertiliser(Fertiliser selectedFertiliser) {
        this.selectedFertiliser.setValue(selectedFertiliser);
    }

    public String getAmount() {
        return String.valueOf(amount.getValue());
    }

    public void setAmount(String amount) {
        this.amount.setValue(Double.parseDouble(amount));
    }

    public ObservableListWrapperA<String> getUoms() {
        return uoms;
    }

    public String getSelectedUom() {
        return selectedUom.getValue();
    }

    public void setSelectedUom(String selectedUom) {
        this.selectedUom.setValue(selectedUom);
    }

    @Override
    public String getFxmlPath() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
