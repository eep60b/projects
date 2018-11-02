package com.etlsolutions.javafx.presentation.menu.add.gvent;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.log.gvent.FloweringGventDetail;
import com.etlsolutions.javafx.system.ProjectManager;

/**
 *
 * @author zc
 */
public class FloweringGventDetailDataModel extends GventDetailDataModel<FloweringGventDetail> {
    
    private final ObservableListWrapperA<String> flowerTypes;
    private final ObservableListWrapperA<String> flowerColors;
    
    public FloweringGventDetailDataModel(FloweringGventDetail floweringGventDetail) {
        super(floweringGventDetail);
        flowerTypes = new ObservableListWrapperA<>(ProjectManager.getInstance().getProject().getFlowerTypes());
        flowerColors = new ObservableListWrapperA<>(ProjectManager.getInstance().getProject().getFlowerColors());
    }

    public ObservableListWrapperA<String> getFlowerTypes() {
        return flowerTypes;
    }

    public ObservableListWrapperA<String> getFlowerColors() {
        return flowerColors;
    }
    
    public String getFlowerType() {
        return detail.getFlowerType();
    }

    public void setFlowerType(String flowerType) {
        detail.setFlowerType(flowerType);
    }    

    public int getCount() {
        return detail.getCount();
    }

    public void setCount(int count) {
        detail.setCount(count);
    }

    public String getColor() {
        return detail.getColor();
    }

    public void setColor(String color) {
        detail.setColor(color);
    }
    
    
    
    @Override
    public String getFxmlPath() {
        return "/fxml/log/FloweringGventFXML.fxml";
    }
    
}
