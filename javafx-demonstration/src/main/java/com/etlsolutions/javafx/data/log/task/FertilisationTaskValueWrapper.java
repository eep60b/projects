package com.etlsolutions.javafx.data.log.task;

import com.etlsolutions.gwise.data.ImageLink;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.gwise.data.log.Notification;
import com.etlsolutions.javafx.data.other.Fertiliser;
import com.etlsolutions.gwise.system.ProjectManager;
import java.time.LocalDateTime;

/**
 *
 * @author zc
 */
public class FertilisationTaskValueWrapper extends TaskValueWrapper {

    private final ValueWrapper<Fertiliser> fertiliserValueWrapper;
    private final ValueWrapper<String> amountValueWrapper;
    private final ValueWrapper<String> uomValueWrapper;

    public FertilisationTaskValueWrapper(String title, String information, ObservableListWrapperA<ImageLink> imageLinks, ImageLink selectedImgLinkIndex, String logoPath, LocalDateTime startTime, ObservableListWrapperA<Notification> notifications, Fertiliser fertiliser, double amount, String uom) {
        super(title, information, imageLinks, selectedImgLinkIndex, logoPath, startTime, notifications);
        fertiliserValueWrapper = new ValueWrapper<>(fertiliser);
        amountValueWrapper = getWrapper(amount);
        uomValueWrapper = new ValueWrapper<>(uom);
    }

    public FertilisationTaskValueWrapper(FertilisationTask task) {
        
        super(task);
        fertiliserValueWrapper = new ValueWrapper<>(ProjectManager.getInstance().<Fertiliser>getItem(task.getFertiliserId()));
        amountValueWrapper = new ValueWrapper<>(String.valueOf(task.getAmount()));
        uomValueWrapper = new ValueWrapper<>(task.getUom());
    }

    public ValueWrapper<Fertiliser> getFertiliserValueWrapper() {
        return fertiliserValueWrapper;
    }

    public ValueWrapper<String> getAmountValueWrapper() {
        return amountValueWrapper;
    }

    public double getAmount() {
        return Double.parseDouble(amountValueWrapper.getValue());
    }
    
    public ValueWrapper<String> getUomValueWrapper() {
        return uomValueWrapper;
    }

    public void setUom(String uom) {
        this.uomValueWrapper.setValue(uom);
    }

    @Override
    public TaskType getType() {
        return TaskType.FERTILZATION;
    }
}
