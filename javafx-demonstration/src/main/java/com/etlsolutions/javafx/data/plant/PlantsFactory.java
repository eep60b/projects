package com.etlsolutions.javafx.data.plant;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.subarea.location.Location;

import static com.etlsolutions.javafx.system.SettingConstants.BUNDLE_SEPARATER;
import static com.etlsolutions.javafx.system.SettingConstants.DATAUNIT_BUNDLE_PATH;
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

            PlantGroup group = createDefaultPlantGroup(title);
            if (title.equals("Annual Plants")) {
                group.getPlantsSubGroups().add(createTitledEmptyPlantSubGroup(group.getId(), "Tomato"));
            }
            if (title.equals("Biennial Plants")) {
                group.getPlantsSubGroups().add(createTitledEmptyPlantSubGroup(group.getId(), "Unset"));
            }
            if (title.equals("Perennial Plants")) {
                group.getPlantsSubGroups().add(createTitledEmptyPlantSubGroup(group.getId(), "Garlic Chive"));
            }
            if (title.equals("Trees")) {
                group.getPlantsSubGroups().add(createTitledEmptyPlantSubGroup(group.getId(), "Apple"));

            }
            r.getPlantGroups().add(group);

        }

        return r;
    }

    public PlantGroup createPlantGroup(DataUnitValueWrapper valueWrapper, ObservableListWrapperA<PlantSubGroup> plantsSubGroups) {
        return new PlantGroup(valueWrapper, plantsSubGroups);
    }

    public PlantGroup createDefaultPlantGroup(String title) {
        PlantGroup g = new PlantGroup();
        g.setTitle(title);
        g.setInformation("");
        g.setImageLinks(new ObservableListWrapperA<ImageLink>());
        g.setSelectedImgLinkIndex(0);
        g.setLogoPath("");
        g.setPlantsSubGroups(new ObservableListWrapperA<PlantSubGroup>());
        return g;
    }

    public PlantSubGroup creatPlantSubGroup(DataUnitValueWrapper valueWrapper, int plantGroupId, ObservableListWrapperA<PlantVariety> plantVarieties) {
        return new PlantSubGroup(valueWrapper, plantGroupId, new ObservableListWrapperA<Plants>(), plantVarieties);
    }

    private PlantSubGroup createTitledEmptyPlantSubGroup(int groupId, String title) {

        DataUnitValueWrapper valueWrapper = new DataUnitValueWrapper(title, "", new ObservableListWrapperA<ImageLink>(), null, "");
        return new PlantSubGroup(valueWrapper, groupId, new ObservableListWrapperA<Plants>(), new ObservableListWrapperA<PlantVariety>());
    }

    public Plants creatPlant(DataUnitValueWrapper valueWrapper, PlantValueWrapper plantValueWrapper) {
        Plants plant = new Plants(valueWrapper, plantValueWrapper);

        Location location = plantValueWrapper.getLocationValueWrapper().getValue();
        if (location != null) {
            location.setPlantId(plant.getId());
        }
        return plant;
    }

    public PlantVariety createPlantVariety(DataUnitValueWrapper valueWrapper, int plantSubGroupId, String latinName, ObservableListWrapperA<String> aliases) {
        return new PlantVariety(valueWrapper, plantSubGroupId, latinName, aliases);
    }
}
