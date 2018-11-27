package com.etlsolutions.javafx.data.plant;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ObservableListWrapperA;

import static com.etlsolutions.javafx.system.SettingConstants.BUNDLE_SEPARATER;
import static com.etlsolutions.javafx.system.SettingConstants.DATAUNIT_BUNDLE_PATH;
import java.util.List;
import java.util.ResourceBundle;

/**
 *
 * @author zc
 */
public class PlantsFactory {

    public static final ResourceBundle BUNDLE = ResourceBundle.getBundle(DATAUNIT_BUNDLE_PATH);
    
    private static final PlantsFactory INSTANCE = new PlantsFactory();
    
    public static PlantsFactory getInstance() {
        return INSTANCE;
    }

    public PlantGroupRoot createPlantsGroupRoot() {
        PlantGroupRoot r = new PlantGroupRoot("");
        String[] defaultTitles = BUNDLE.getString("com.etlsolutions.javafx.data.plant.PlantsFactory.defaultPlantsGroup.Titles").split(BUNDLE_SEPARATER);

        for (String title : defaultTitles) {
            
            title = title.trim();
            
            PlantGroup group = new PlantGroup(title, "", new ObservableListWrapperA<ImageLink>(), 0, "");
            if(title.equals("Annual Plants")) {
                group.getPlantsSubGroups().add(creatPlantsType(0, new ObservableListWrapperA<Plants>(), new ObservableListWrapperA<PlantVariety>(), "Tomato", "", new ObservableListWrapperA<ImageLink>(), 0, ""));
            }
            if(title.equals("Biennial Plants")) {
                group.getPlantsSubGroups().add(creatPlantsType(0, new ObservableListWrapperA<Plants>(), new ObservableListWrapperA<PlantVariety>(), "Unset", "", new ObservableListWrapperA<ImageLink>(), 0, ""));
            }
            if(title.equals("Perennial Plants")) {
                group.getPlantsSubGroups().add(creatPlantsType(0, new ObservableListWrapperA<Plants>(), new ObservableListWrapperA<PlantVariety>(), "Garlic Chive", "", new ObservableListWrapperA<ImageLink>(), 0, ""));
            }
            if(title.equals("Trees")) {
                group.getPlantsSubGroups().add(creatPlantsType(0, new ObservableListWrapperA<Plants>(), new ObservableListWrapperA<PlantVariety>(), "Apple", "", new ObservableListWrapperA<ImageLink>(), 0, ""));
            }            
            r.getPlantGroups().add(group);
            
        }
        
        return r;
    }

    public PlantGroup createDefaultPlantGroup() {
        return new PlantGroup("untitled", "", new ObservableListWrapperA<ImageLink>(), 0, "");
    }


    
    public PlantSubGroup creatPlantsType(int plantGroupId, ObservableListWrapperA<Plants> plantsList, ObservableListWrapperA<PlantVariety> plantVarieties, String title, String information, ObservableListWrapperA<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        return new PlantSubGroup(plantGroupId, plantsList, plantVarieties, title, information, imageLinks, selectedImgLinkIndex, logoPath);
    }

    public PlantSubGroup creatPlantsType() {
        PlantSubGroup t = new PlantSubGroup();

        t.setTitle("untitled");
        t.setInformation("");
        t.setLogoPath("");
        return t;
    }

    public Plants creatPlant(DataUnitValueWrapper valueWrapper, PlantValueWrapper plantValueWrapper) {
        Plants p = new Plants(valueWrapper, plantValueWrapper);        

        return p;
    }

    public PlantVariety createPlantVariety(String title, String latinName, String information, List<String> aliases, List<ImageLink> imageLinks) {
        return new PlantVariety();
    }

    public PlantVariety createPlantVariety() {
        PlantVariety v = new PlantVariety();
        v.setTitle("Not specified");
        v.setLatinName("Not specified");
  
        return v;
    }


}
