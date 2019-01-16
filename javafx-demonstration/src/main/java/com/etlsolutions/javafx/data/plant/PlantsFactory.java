package com.etlsolutions.javafx.data.plant;

import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.subarea.location.Location;
import com.etlsolutions.javafx.data.log.GrowingIssue;
import com.etlsolutions.javafx.data.log.GrowingObservation;
import com.etlsolutions.javafx.data.log.gvent.Gvent;
import com.etlsolutions.javafx.data.log.task.Task;
import com.etlsolutions.javafx.system.ProjectContents;
import com.etlsolutions.javafx.system.ProjectManager;

import static com.etlsolutions.javafx.system.SettingConstants.BUNDLE_SEPARATER;
import static com.etlsolutions.javafx.system.SettingConstants.DATAUNIT_BUNDLE_PATH;
import java.time.LocalDateTime;
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
                group.getPlantSubGroups().add(createTitledEmptyPlantSubGroup(group, "Tomato"));
            }
            if (title.equals("Biennial Plants")) {
                group.getPlantSubGroups().add(createTitledEmptyPlantSubGroup(group, "Unset"));
            }
            if (title.equals("Perennial Plants")) {
                group.getPlantSubGroups().add(createTitledEmptyPlantSubGroup(group, "Garlic Chive"));
            }
            if (title.equals("Trees")) {
                group.getPlantSubGroups().add(createTitledEmptyPlantSubGroup(group, "Apple"));

            }
            r.getPlantGroups().add(group);

        }

        return r;
    }

    public PlantGroup createPlantGroup(PlantGroupValueWrapper valueWrapper) {
        return new PlantGroup(valueWrapper);
    }
    
    public PlantGroupValueWrapper createDefaultPlantGroupValueWrapper() {

        return new PlantGroupValueWrapper("Untitled", "", new ObservableListWrapperA<ImageLink>(), null, "", new ObservableListWrapperA<PlantSubGroup>());
    }
    
    public PlantGroup createDefaultPlantGroup(String title) {
        PlantGroup g = new PlantGroup();
        g.setTitle(title);
        g.setInformation("");
        g.setImageLinks(new ObservableListWrapperA<ImageLink>());
        g.setSelectedImgLinkIndex(0);
        g.setLogoPath("");
        g.setPlantSubGroups(new ObservableListWrapperA<PlantSubGroup>());
        return g;
    }

    public PlantSubGroup creatPlantSubGroup(PlantSubGroupValueWrapper valueWrapper) {
        return new PlantSubGroup(valueWrapper);
    }

    private PlantSubGroup createTitledEmptyPlantSubGroup(PlantGroup group, String title) {

        PlantSubGroupValueWrapper valueWrapper = new PlantSubGroupValueWrapper(title, "", new ObservableListWrapperA<ImageLink>(), null, "", group, new ObservableListWrapperA<Plants>(), new ObservableListWrapperA<PlantVariety>());
        return new PlantSubGroup(valueWrapper);
    }

    public PlantSubGroupValueWrapper creatDefaultPlantSubGroupValueWrapper(PlantGroup group) {
        return new PlantSubGroupValueWrapper("Untitled", "", new ObservableListWrapperA<ImageLink>(), null, "", group, new ObservableListWrapperA<Plants>(), new ObservableListWrapperA<PlantVariety>());
    }    
    
    public PlantValueWrapper createDefaultPlantWrapper() {
        ProjectContents pc = ProjectManager.getInstance().getContents();
        PlantGroup pg = pc.getPlantsGroupRoot().getPlantGroups().get(0);
        PlantSubGroup sg = pg.getPlantSubGroups().get(0);
        ObservableListWrapperA<PlantVariety> varieties = sg.getPlantVarieties();

        return new PlantValueWrapper("Untitled", "", new ObservableListWrapperA<ImageLink>(), null, "", pg, sg, null, true,
                GrowingStartPoint.SEED, LocalDateTime.now(), pc.getGrowingMediums().get(0), varieties.isEmpty() ? null : varieties.get(0),
                0, PlantsQuantity.Type.SINGLE, "", LocalDateTime.MAX, new ObservableListWrapperA<Gvent>(), new ObservableListWrapperA<GrowingIssue>(),
                new ObservableListWrapperA<GrowingObservation>(), new ObservableListWrapperA<Task>());
    }

    public Plants creatPlant(PlantValueWrapper plantValueWrapper) {
        Plants plant = new Plants(plantValueWrapper);

        Location location = plantValueWrapper.getLocationValueWrapper().getValue();

        if (location != null) {
            location.setPlantId(plant.getId());
        }
        
        return plant;

    }

    public PlantVarietyValueWrapper createDefaultPlantVarietyValueWrapper(PlantSubGroup subGroup) {
        return new PlantVarietyValueWrapper("Untitled", "", new ObservableListWrapperA<ImageLink>(), null, "", new ObservableListWrapperA<String>(), "", subGroup);
    }
    
    public PlantVariety createPlantVariety(PlantVarietyValueWrapper valueWrapper) {
        return new PlantVariety(valueWrapper);
    }
}
