package com.etlsolutions.javafx.data.plant;

import com.etlsolutions.javafx.data.GrowingMedium;
import static com.etlsolutions.javafx.data.DataUnit.BUNDLE;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.log.GrowingIssue;
import com.etlsolutions.javafx.data.log.GrowingObservation;
import com.etlsolutions.javafx.data.log.gvent.FloweringGvent;
import com.etlsolutions.javafx.data.log.gvent.FruitingGvent;
import com.etlsolutions.javafx.data.log.task.FertilisationTask;
import com.etlsolutions.javafx.data.log.task.HarvestingTask;
import com.etlsolutions.javafx.data.log.task.PlantThinningTask;
import com.etlsolutions.javafx.data.log.task.TransplantTask;
import com.etlsolutions.javafx.data.log.task.WateringTask;
import com.etlsolutions.javafx.data.plant.GrowingStartPoint.Source;
import static com.etlsolutions.javafx.system.SettingConstants.BUNDLE_SEPARATER;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public class PlantsFactory {


    public static PlantGroupRoot createPlantsGroupRoot() {
        PlantGroupRoot r = new PlantGroupRoot();
        String[] defaultTitles = BUNDLE.getString("com.etlsolutions.javafx.data.plant.PlantsFactory.defaultPlantsGroup.Titles").split(BUNDLE_SEPARATER);

        for (String title : defaultTitles) {
            PlantGroup group = createPlantsGroup(title, "");
            if(title.equals("Annual Plants")) {
                group.getPlantsTypes().add(creatPlantsType("Tomato", ""));
            }
            if(title.equals("Biennial Plants")) {
                group.getPlantsTypes().add(creatPlantsType("Unset", ""));
            }
            if(title.equals("Perennial Plants")) {
                group.getPlantsTypes().add(creatPlantsType("Garlic Chive", ""));
            }
            if(title.equals("Trees")) {
                group.getPlantsTypes().add(creatPlantsType("Appleo", ""));
            }            
            r.getPlantGroups().add(group);
            
        }
        
        return r;
    }

    public static PlantGroup createPlantsGroup() {
        return createPlantsGroup("untitled", "");
    }

    public static PlantGroup createPlantsGroup(String title, String information) {
        return new PlantGroup(title, information);
    }

    public static PlantType creatPlantsType(String title, String information) {
        return new PlantType(title, information);
    }
    
    public static PlantType creatPlantsType(String title, String information, ObservableList<PlantVariety> varieties, ObservableList<ImageLink> imageLinks) {
        return new PlantType(title, information, imageLinks, varieties);
    }

    public static PlantType creatPlantsType() {
        PlantType t = new PlantType();

        t.setTitle("untitled");
        t.setInformation("");
        t.setLogoPath("");
        return t;
    }

    public static Plants creatPlants() {
        Plants p = new Plants();        
        p.setTitle("untitled");
        p.setInformation("");
        p.setLogoPath("");
        p.setVariety(createPlantVariety());
        p.setQuantity(createPlantsQuantity());
        p.setGrowingDetails(createGrowingDetail());
        return p;
    }

    public static PlantVariety createPlantVariety(String title, String latinName, String information, List<String> aliases, List<ImageLink> imageLinks) {
        return new PlantVariety(aliases, latinName, title, information);
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
        d.setFloweringEvents(new ArrayList<FloweringGvent>());
        d.setFruitingEvents(new ArrayList<FruitingGvent>());
        d.setGrowingIssues(new ArrayList<GrowingIssue>());
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
