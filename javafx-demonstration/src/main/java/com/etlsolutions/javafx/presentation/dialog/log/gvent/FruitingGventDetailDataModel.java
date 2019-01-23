package com.etlsolutions.javafx.presentation.dialog.log.gvent;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.log.gvent.FruitingGventValueWrapper;
import com.etlsolutions.javafx.system.ProjectManager;

/**
 *
 * @author zc
 */
public class FruitingGventDetailDataModel extends GventDetailDataModel<FruitingGventValueWrapper> {

    private final ObservableListWrapperA<String> fruitShapes;
    private final ObservableListWrapperA<String> fruitColors;

    public FruitingGventDetailDataModel(FruitingGventValueWrapper fruitingGventDetail) {
        super(fruitingGventDetail);
        fruitShapes = new ObservableListWrapperA<>(ProjectManager.getInstance().getContents().getFruitShapes());
        fruitColors = new ObservableListWrapperA<>(ProjectManager.getInstance().getContents().getFruitColors());
    }

    public ObservableListWrapperA<String> getFruitShapes() {

        return fruitShapes;
    }

    public ObservableListWrapperA<String> getFruitColors() {
        return fruitColors;
    }

    public ValueWrapper<Boolean> getCountable() {
        return detail.getCountableValueWrapper();
    }

    public ValueWrapper<Integer> getCount() {
        return detail.getCountValueWrapper();
    }

    public ValueWrapper<String> getColor() {
        return detail.getColorValueWrapper();
    }

    public ValueWrapper<String> getShape() {
        return detail.getShapeValueWrapper();
    }

    public ValueWrapper<String> getAverageSize() {
        return detail.getAverageSizeValueWrapper();
    }

    public ValueWrapper<String> getAverageWeight() {
        return detail.getAverageWeightValueWrapper();
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/log/FruitingGventFXML.fxml";
    }
}
