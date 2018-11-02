package com.etlsolutions.javafx.presentation.menu.add.gvent;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.log.gvent.FruitingGventDetail;
import com.etlsolutions.javafx.system.ProjectManager;

/**
 *
 * @author zc
 */
public class FruitingGventDetailDataModel extends GventDetailDataModel<FruitingGventDetail> {

    private final ObservableListWrapperA<String> fruitShapes;
    private final ObservableListWrapperA<String> fruitColors;

    public FruitingGventDetailDataModel(FruitingGventDetail fruitingGventDetail) {
        super(fruitingGventDetail);
        fruitShapes = new ObservableListWrapperA<>(ProjectManager.getInstance().getProject().getFruitShapes());
        fruitColors = new ObservableListWrapperA<>(ProjectManager.getInstance().getProject().getFruitColors());
    }

    public ObservableListWrapperA<String> getFruitShapes() {

        return fruitShapes;
    }

    public ObservableListWrapperA<String> getFruitColors() {
        return fruitColors;
    }
    
    public ValueWrapper<Boolean> getCountable() {
        return detail.getCountable();
    }    
    
    public ValueWrapper<Integer> getCount() {
        return detail.getCount();
    }

    public ValueWrapper<String> getColor() {
        return detail.getColor();
    }

    public ValueWrapper<String> getShape() {
        return detail.getShape();
    }

    public ValueWrapper<String> getAverageSize() {
        return detail.getAverageSize();
    }

    public ValueWrapper<String> getAverageWeight() {
        return detail.getAverageWeight();
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/log/FruitingGventFXML.fxml";
    }


}
