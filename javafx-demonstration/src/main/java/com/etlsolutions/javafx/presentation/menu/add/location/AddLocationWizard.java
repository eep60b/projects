package com.etlsolutions.javafx.presentation.menu.add.location;

import com.etlsolutions.javafx.data.area.subarea.SubAreaType;
import com.etlsolutions.javafx.presentation.wizard.Wizard;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author zc
 */
public class AddLocationWizard extends Wizard<AddLocationWizardDataModel> {

    private final TypeSelectionPage typeSelectionPage;
    private final Map<SubAreaType, VBox> specificationPageMap;
    private final LocationImagesPage locationImagesPage;
    
    public AddLocationWizard(Stage stage, AddLocationWizardDataModel model) {
        super(stage, model);
        typeSelectionPage = new TypeSelectionPage(new TypeSelectionDataModel(model));        
        Map<SubAreaType, VBox> map = new HashMap<>();
        map.put(SubAreaType.BORDER, new BorderContentPage());
        map.put(SubAreaType.SINGLE_CONTAINTER, new ContainerContentPage());
        map.put(SubAreaType.CONTAINTER_SET, new ContainerSetContentPage());
        
        specificationPageMap = Collections.unmodifiableMap(map);
        
        locationImagesPage = new LocationImagesPage();
        init();
    }

    @Override
    protected Node getCurrentPage() {
        
        switch(model.getCurrentIndex()) {
            
            case 0: return typeSelectionPage;
            case 1: return specificationPageMap.get(model.getSelectedType());
            case 2: return locationImagesPage;            
            default: throw new IllegalStateException("Invalid current index.");
        }
    }
}
