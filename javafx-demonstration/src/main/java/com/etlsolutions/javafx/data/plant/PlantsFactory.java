package com.etlsolutions.javafx.data.plant;

import static com.etlsolutions.javafx.data.DataUnit.BUNDLE;
import com.etlsolutions.javafx.data.DataUnitIdRegistry;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.log.GrowingIssue;
import com.etlsolutions.javafx.data.log.GrowingObservation;
import com.etlsolutions.javafx.data.log.event.FloweringEvent;
import com.etlsolutions.javafx.data.log.event.FruitingEvent;
import com.etlsolutions.javafx.data.log.task.FertilisationTask;
import com.etlsolutions.javafx.data.log.task.HarvestingTask;
import com.etlsolutions.javafx.data.log.task.PlantThinningTask;
import com.etlsolutions.javafx.data.log.task.TransplantTask;
import com.etlsolutions.javafx.data.log.task.WateringTask;
import com.etlsolutions.javafx.data.plant.GrowingStartPoint.Source;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author zc
 */
public class PlantsFactory {

    private static final Map<String, double[]> DEFAULT_VALUES = new HashMap<>();
    private static final List<String> DEFAULT_TITLES = new ArrayList<>();

    static {
        DEFAULT_VALUES.put("Loam", new double[]{28, 28, 14, 20, 0, 10, 7.0});
        DEFAULT_VALUES.put("Sandy soil", new double[]{50, 35, 5, 5, 0, 5, 6.5});
        DEFAULT_VALUES.put("Silt soil", new double[]{25, 50, 5, 10, 0, 10, 6.8});
        DEFAULT_VALUES.put("Peat soi", new double[]{10, 10, 5, 50, 0, 25, 6.3});
        DEFAULT_VALUES.put("Clay soil (light)", new double[]{15, 15, 45, 15, 0, 10, 7.0});
        DEFAULT_VALUES.put("Clay soil (heavy)", new double[]{10, 10, 60, 10, 0, 10, 7.0});
        DEFAULT_VALUES.put("Chalky soil", new double[]{28, 28, 14, 10, 20, 10, 7.0});
        DEFAULT_VALUES.put("Multipurpose compost", new double[]{0, 0, 0, 80, 0, 20, 7.0});
        DEFAULT_VALUES.put("Ericaceous compost", new double[]{0, 0, 0, 80, 0, 20, 5.2});
        DEFAULT_VALUES.put("Stony soil", new double[]{30, 10, 0, 5, 50, 5, 7.0});
        DEFAULT_VALUES.put("Plant liquid culture", new double[]{0, 0, 0, 0, 0, 100, 15});
        DEFAULT_TITLES.addAll(DEFAULT_VALUES.keySet());
        Collections.sort(DEFAULT_TITLES);
    }

    public static PlantsGroupRoot createPlantsGroupRoot() {
        PlantsGroupRoot r = new PlantsGroupRoot();
        r.setId(DataUnitIdRegistry.createNewId());
        String[] defaultTitles = BUNDLE.getString("com.etlsolutions.javafx.data.plant.PlantsFactory.defaultPlantsGroup.Titles").split(",");
        List<PlantsGroup> groups = new ArrayList<>();
        for (String title : defaultTitles) {
            PlantsGroup group = createPlantsGroup(title);
            groups.add(group);
        }
        r.setPlantsGroups(groups);
        return r;
    }

    public static PlantsGroup createPlantsGroup() {
        return createPlantsGroup("untitled");
    }

    public static PlantsGroup createPlantsGroup(String title) {
        PlantsGroup g = new PlantsGroup();
        g.setId(DataUnitIdRegistry.createNewId());
        g.setTitle(title);
        g.setInformation("");
        g.setLogoPath("");
        g.setPlantsTypes(new ArrayList<PlantsType>());
        return g;
    }
    
    

    public static PlantsType creatPlantsType() {
        PlantsType t = new PlantsType();
        t.setId(DataUnitIdRegistry.createNewId());
        t.setTitle("untitled");
        t.setInformation("");
        t.setLogoPath("");
        t.setPlantsList(new ArrayList<Plants>());
        return t;
    }

    public static Plants creatPlants() {
        Plants p = new Plants();
        p.setId(DataUnitIdRegistry.createNewId());
        p.setTitle("untitled");
        p.setInformation("");
        p.setLogoPath("");
        p.setVariety(createPlantVariety());
        p.setQuantity(createPlantsQuantity());
        p.setGrowingDetails(createGrowingDetail());
        return p;
    }

    public static PlantVariety createPlantVariety(String title, String latinName, String information, List<String> aliases, List<ImageLink> imageLinks) {
        PlantVariety v = new PlantVariety(aliases, latinName, title, information, imageLinks);
        v.setTitle("Not specified");
        v.setLatinName("Not specified");
        v.setInformation(information);
        v.setAliases(new ArrayList<String>());
        return v;
    }    
    
    public static PlantVariety createPlantVariety() {
        PlantVariety v = new PlantVariety();
        v.setTitle("Not specified");
        v.setLatinName("Not specified");
        v.setAliases(new ArrayList<String>());
        return v;
    }

    public static PlantsQuantity createPlantsQuantity() {
        PlantsQuantity p = new PlantsQuantity();
        return p;
    }

    public static GrowingDetail createGrowingDetail() {
        GrowingDetail d = new GrowingDetail();
        d.setFertilisationTasks(new ArrayList<FertilisationTask>());
        d.setFloweringEvents(new ArrayList<FloweringEvent>());
        d.setFruitingEvents(new ArrayList<FruitingEvent>());
        d.setGrowingIssues(new ArrayList<GrowingIssue>());
        d.setGrowingMedium(createGrowingMedium(DEFAULT_TITLES.get(0)));
        d.setGrowingObservations(new ArrayList<GrowingObservation>());
        d.setGrowingTermination(createGrowingTermination());
        d.setHarvestingTasks(new ArrayList<HarvestingTask>());
        d.setIsAlive(true);
        d.setPlantThinningTasks(new ArrayList<PlantThinningTask>());
        d.setStartPoint(createGrowingStartPoint());
        d.setTransplantTasks(new ArrayList<TransplantTask>());
        d.setWateringTasks(new ArrayList<WateringTask>());
        return d;
    }

    public static GrowingMedium createGrowingMedium(String title) {
        double[] values = DEFAULT_VALUES.get(title);
        return values == null ? new GrowingMedium(title, DEFAULT_VALUES.get(DEFAULT_TITLES.get(0)), true) : new GrowingMedium(title, values, true);
    }

    public static GrowingStartPoint createGrowingStartPoint() {
        GrowingStartPoint p = new GrowingStartPoint();
        p.setSource(Source.SEED);
        p.setTime(new Date());
        return p;
    }

    public static GrowingTermination createGrowingTermination() {
        GrowingTermination t = new GrowingTermination();
        t.setReason("Not specified");
        t.setTime(new Date());
        return t;
    }
}
