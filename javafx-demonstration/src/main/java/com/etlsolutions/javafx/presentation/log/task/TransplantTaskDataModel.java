package com.etlsolutions.javafx.presentation.log.task;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.area.subarea.location.Location;
import com.etlsolutions.javafx.data.log.task.TransplantTask;
import com.etlsolutions.javafx.data.log.task.TransplantTasklValueWrapper;
import com.etlsolutions.javafx.presentation.RemoveEventId;
import com.etlsolutions.javafx.system.ProjectManager;

/**
 *
 * @author zc
 */
public class TransplantTaskDataModel extends TaskDetailDataModel<TransplantTasklValueWrapper> {

    public static final RemoveEventId AREA_REMOVE_EVENT_ID = new RemoveEventId(TransplantTaskDataModel.class.getName() + "AREA_REMOVE_EVENT_ID", "remove area");

    private int plantId;
    private final ObservableListWrapperA<Area> fromAreas;
    private final ValueWrapper<Area> selectedFromArea;
    private final ObservableListWrapperA<SubArea> fromSubAreas;
    private final ValueWrapper<SubArea> selectedFromSubArea;
    private final ObservableListWrapperA<Location> fromLocations;
    private final ObservableListWrapperA<Area> toAreas;
    private final ValueWrapper<Area> selectedToArea;
    private final ObservableListWrapperA<SubArea> toSubAreas;
    private final ValueWrapper<SubArea> selectedToSubArea;
    private final ObservableListWrapperA<Location> toLocations;

    public TransplantTaskDataModel(int plantId, TransplantTask task) {

        super(new TransplantTasklValueWrapper(task));

        this.plantId = plantId;
        ProjectManager p = ProjectManager.getInstance();
        selectedFromSubArea = new ValueWrapper<>((SubArea) p.getItem(detail.getFromLocationValueWrapper().getValue().getParentId()));
        fromLocations = selectedFromSubArea.getValue().getAllLocations();
        selectedFromArea = new ValueWrapper<>((Area) p.getItem(selectedFromSubArea.getValue().getParentId()));
        fromSubAreas = selectedFromArea.getValue().getAllSubAreas();
        fromAreas = new ObservableListWrapperA<>(ProjectManager.getInstance().getContents().getAreaRoot().getAllAreas());

        selectedToSubArea = new ValueWrapper<>((SubArea) p.getItem(detail.getToLocationValueWrapper().getValue().getParentId()));
        toLocations = selectedToSubArea.getValue().getAllLocations();
        selectedToArea = new ValueWrapper<>((Area) p.getItem(selectedToSubArea.getValue().getParentId()));
        toSubAreas = selectedToArea.getValue().getAllSubAreas();
        toAreas = new ObservableListWrapperA<>(ProjectManager.getInstance().getContents().getAreaRoot().getAllAreas());
    }

    public TransplantTaskDataModel(TransplantTasklValueWrapper wrapper) {

        super(wrapper);
        fromAreas = new ObservableListWrapperA<>(ProjectManager.getInstance().getContents().getAreaRoot().getAllAreas());
        selectedFromArea = new ValueWrapper<>(fromAreas.get(0));
        fromSubAreas = selectedFromArea.getValue().getAllSubAreas();
        selectedFromSubArea = new ValueWrapper<>(fromSubAreas.get(0));
        fromLocations = selectedFromSubArea.getValue().getAllLocations();
        toAreas = new ObservableListWrapperA<>(ProjectManager.getInstance().getContents().getAreaRoot().getAllAreas());
        selectedToArea = new ValueWrapper<>(toAreas.get(0));
        toSubAreas = selectedToArea.getValue().getAllSubAreas();
        selectedToSubArea = new ValueWrapper<>(toSubAreas.get(0));
        toLocations = selectedToSubArea.getValue().getAllLocations();
        detail.getFromLocationValueWrapper().setValue(fromLocations.get(0));
        detail.getToLocationValueWrapper().setValue(toLocations.get(0));
    }

    public int getPlantId() {
        return plantId;
    }

    public void setPlantId(int plantId) {
        this.plantId = plantId;
    }

    public ObservableListWrapperA<Location> getFromLocations() {
        return fromLocations;
    }

    public static RemoveEventId getAREA_REMOVE_EVENT_ID() {
        return AREA_REMOVE_EVENT_ID;
    }

    public ObservableListWrapperA<Area> getFromAreas() {
        return fromAreas;
    }

    public ValueWrapper<Area> getSelectedFromArea() {
        return selectedFromArea;
    }

    public ObservableListWrapperA<SubArea> getFromSubAreas() {
        return fromSubAreas;
    }

    public ValueWrapper<SubArea> getSelectedFromSubArea() {
        return selectedFromSubArea;
    }

    public ValueWrapper<Location> getFromLocation() {
        return detail.getFromLocationValueWrapper();
    }

    public ObservableListWrapperA<Area> getToAreas() {
        return toAreas;
    }

    public ValueWrapper<Area> getSelectedToArea() {
        return selectedToArea;
    }

    public ObservableListWrapperA<SubArea> getToSubAreas() {
        return toSubAreas;
    }

    public ValueWrapper<SubArea> getSelectedToSubArea() {
        return selectedToSubArea;
    }

    public ObservableListWrapperA<Location> getToLocations() {
        return toLocations;
    }

    public ValueWrapper<Location> getToLocation() {
        return detail.getToLocationValueWrapper();
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/log/TransplantTaskFXML.fxml";
    }

    @Override
    public void remove(RemoveEventId id) {

    }

    @Override
    public void save() {
    }

}
