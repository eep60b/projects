package com.etlsolutions.javafx.presentation.log.gvent;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.log.Notification;
import com.etlsolutions.javafx.data.log.gvent.FloweringGvent;
import com.etlsolutions.javafx.data.log.gvent.FloweringGventDetailValueWrapper;
import com.etlsolutions.javafx.data.log.gvent.FruitingGvent;
import com.etlsolutions.javafx.data.log.gvent.FruitingGventDetailValueWrapper;
import com.etlsolutions.javafx.data.log.gvent.Gvent;
import com.etlsolutions.javafx.data.log.gvent.GventType;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import com.etlsolutions.javafx.presentation.FXMLActionDataModel;
import com.etlsolutions.javafx.presentation.FXMLContentActionDataModel;
import com.etlsolutions.javafx.presentation.RemoveEventId;
import com.etlsolutions.javafx.presentation.log.Notifiable;
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
    private GventDetailDataModel detailDataModelValueWrapper;

    public AbstractGventDataModel() {

        types = new ObservableListWrapperA<>(GventType.values());
        selectedTypeValueWrapper = new ValueWrapper<>(types.get(0));
        detailDataModelValueWrapper = getDetailDataModel(selectedTypeValueWrapper.getValue());
        selectedNotification = new ValueWrapper<>(null);
    }

    public AbstractGventDataModel(Gvent gvent) {
        super(gvent);
        detailDataModelValueWrapper = getDetailDataModel(gvent);
        selectedNotification = new ValueWrapper<>(gvent.getNotifications().get(0));
        types = new ObservableListWrapperA<>(gvent.getType());
        selectedTypeValueWrapper = new ValueWrapper<>(gvent.getType());
    }

    public final GventDetailDataModel getDetailDataModel(GventType type) {
        switch (type) {
            case FLOWERING:
                return new FloweringGventDetailDataModel(new FloweringGventDetailValueWrapper());
            case FRUITING:
                return new FruitingGventDetailDataModel(new FruitingGventDetailValueWrapper());
            default:
                return null;
        }
    }

    private GventDetailDataModel getDetailDataModel(Gvent gvent) {
        
        switch (gvent.getType()) {
            case FLOWERING:
                return new FloweringGventDetailDataModel(new FloweringGventDetailValueWrapper((FloweringGvent)gvent));
            case FRUITING:
                return new FruitingGventDetailDataModel(new FruitingGventDetailValueWrapper((FruitingGvent)gvent));
            default:
                return null;
        }
    }

    /**
     *
     * @return
     */
    @Override
    public GventDetailDataModel getContentModel() {
        return detailDataModelValueWrapper;
    }

    @Override
    public void setContentModel(FXMLActionDataModel model) {
        detailDataModelValueWrapper = (GventDetailDataModel) model;
    }
    
    public ObservableListWrapperA<GventType> getTypes() {
        return types;
    }

    public ValueWrapper<GventType> getSelectedTypeValueWrapper() {
        return selectedTypeValueWrapper;
    }

    public ValueWrapper<LocalDateTime> getStartTimeValueWrapper() {
        return detailDataModelValueWrapper.getDetail().getStartTimeValueWrapper();
    }

    public ValueWrapper<LocalDateTime> getEndTimeValueWrapper() {
        return detailDataModelValueWrapper.getDetail().getEndTimeValueWrapper();
    }

    @Override
    public ObservableListWrapperA<Notification> getNotifications() {
        return detailDataModelValueWrapper.getDetail().getNotifications();
    }

    @Override
    public ValueWrapper<Notification> getSelectedNotification() {
        return selectedNotification;
    }

    @Override
    public void remove(RemoveEventId id) {

        if (Objects.equals(id, NOTIFICATION_REMOVE_EVENT_ID)) {
            detailDataModelValueWrapper.getDetail().getNotifications().remove(selectedNotification.getValue());
        }

        super.remove(id);
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/log/GventFXML.fxml";
    }
}
