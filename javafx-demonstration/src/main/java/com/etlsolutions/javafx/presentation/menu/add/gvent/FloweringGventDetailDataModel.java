package com.etlsolutions.javafx.presentation.menu.add.gvent;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.log.gvent.FloweringGventDetailValueWrapper;
import com.etlsolutions.javafx.system.ProjectManager;

/**
 *
 * @author zc
 */
public class FloweringGventDetailDataModel extends GventDetailDataModel<FloweringGventDetailValueWrapper> {
    
    private final ObservableListWrapperA<String> flowerTypes;
    private final ObservableListWrapperA<String> flowerColors;
    
    public FloweringGventDetailDataModel(FloweringGventDetailValueWrapper floweringGventDetail) {
        super(floweringGventDetail);
        flowerTypes = new ObservableListWrapperA<>(ProjectManager.getInstance().getContents().getFlowerTypes());
        flowerColors = new ObservableListWrapperA<>(ProjectManager.getInstance().getContents().getFlowerColors());
    }

    public ObservableListWrapperA<String> getFlowerTypes() {
        return flowerTypes;
    }

    public ObservableListWrapperA<String> getFlowerColors() {
        return flowerColors;
    }
    
    public ValueWrapper<String> getFlowerTypeValueWrapper() {
        return detail.getFlowerTypeValueWrapper();
    }


    public ValueWrapper<String> getColorValueWrapper() {
        return detail.getColorValueWrapper();
    }

    public ValueWrapper<Integer> getNumberPerPlantValueWrapper() {
        return detail.getNumberPerPlantValueWrapper();
    }
  
    @Override
    public String getFxmlPath() {
        return "/fxml/log/FloweringGventFXML.fxml";
    }
    
}
