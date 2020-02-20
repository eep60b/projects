package com.etlsolutions.javafx.presentation.dialog.log.gvent;

import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.javafx.data.log.Notification;
import com.etlsolutions.javafx.data.log.gvent.Gvent;
import com.etlsolutions.javafx.data.log.gvent.GventDetailValueWrapper;
import com.etlsolutions.javafx.data.log.gvent.GventType;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import com.etlsolutions.gwise.presentation.FXMLActionDataModel;
import com.etlsolutions.gwise.presentation.FXMLContentActionDataModel;
import com.etlsolutions.javafx.presentation.RemoveEventId;
import com.etlsolutions.javafx.presentation.DetailDataModelGenerator;
import com.etlsolutions.javafx.presentation.dialog.log.Notifiable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author zc
 */
public abstract class AbstractGventDataModel extends DataUnitFXMLDataModel<Gvent> implements Notifiable, FXMLContentActionDataModel {

    public static final String SELECTED_TYPE_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.gvent.AbstractGventDataModel.SELECTED_TYPE_PROPERTY";
    public static final String SELECTED_NOTIFICATION_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.gvent.AbstractGventDataModel.SELECTED_NOTIFICATION_PROPERTY";

    public static final RemoveEventId NOTIFICATION_REMOVE_EVENT_ID = new RemoveEventId("com.etlsolutions.javafx.presentation.menu.add.gvent.AbstractGventDataModel.NOTIFICATION_REMOVE_EVENT_ID", "remove notification");

    private final ObservableListWrapperA<GventType> types;
    private final ValueWrapper<GventType> selectedTypeValueWrapper;
    private final ValueWrapper<Notification> selectedNotification;
    private GventDetailValueWrapper gventDetailValueWrapper;
    protected GventDetailDataModel detailDataModel;
    

    public AbstractGventDataModel() {

        types = new ObservableListWrapperA<>(GventType.values());
        selectedTypeValueWrapper = new ValueWrapper<>(types.get(0));
        detailDataModel = DetailDataModelGenerator.getInstance().getDetailDataModel(selectedTypeValueWrapper.getValue());
        selectedNotification = new ValueWrapper<>(null);
    }

    public AbstractGventDataModel(Gvent gvent) {
        set(gvent);
        detailDataModel = DetailDataModelGenerator.getInstance().getDetailDataModel(gvent);
        selectedNotification = new ValueWrapper<>(gvent.getNotifications().get(0));
        types = new ObservableListWrapperA<>(gvent.getType());
        selectedTypeValueWrapper = new ValueWrapper<>(gvent.getType());
    }


    /**
     *
     * @return
     */
    @Override
    public GventDetailDataModel getContentModel() {
        return detailDataModel;
    }

    @Override
    public void setContentModel(FXMLActionDataModel model) {
        detailDataModel = (GventDetailDataModel) model;
    }
    
    public ObservableListWrapperA<GventType> getTypes() {
        return types;
    }

    public ValueWrapper<GventType> getSelectedTypeValueWrapper() {
        return selectedTypeValueWrapper;
    }

    public ValueWrapper<LocalDateTime> getStartTimeValueWrapper() {
        return detailDataModel.getDetail().getStartTimeValueWrapper();
    }

    public ValueWrapper<LocalDateTime> getEndTimeValueWrapper() {
        return detailDataModel.getDetail().getEndTimeValueWrapper();
    }

    @Override
    public ObservableListWrapperA<Notification> getNotifications() {
        return detailDataModel.getDetail().getNotifications();
    }

    @Override
    public ValueWrapper<Notification> getSelectedNotification() {
        return selectedNotification;
    }

    @Override
    public void remove(RemoveEventId id) {

        if (Objects.equals(id, NOTIFICATION_REMOVE_EVENT_ID)) {
            detailDataModel.getDetail().getNotifications().remove(selectedNotification.getValue());
        }

        super.remove(id);
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/log/GventFXML.fxml";
    }

    @Override
    protected GventDetailValueWrapper getValueWrapper() {
        return gventDetailValueWrapper;
    }
}
