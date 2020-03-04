package com.etlsolutions.javafx.data.log;

import com.etlsolutions.gwise.data.log.Notification;
import com.etlsolutions.javafx.data.DataUnitValueWrapper;
import com.etlsolutions.gwise.data.ImageLink;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.log.gvent.CustomGvent;
import com.etlsolutions.javafx.data.log.gvent.CustomGventDetailValueWrapper;
import com.etlsolutions.javafx.data.log.gvent.FloweringGvent;
import com.etlsolutions.javafx.data.log.gvent.FloweringGventValueWrapper;
import com.etlsolutions.javafx.data.log.gvent.FruitingGvent;
import com.etlsolutions.javafx.data.log.gvent.FruitingGventValueWrapper;
import com.etlsolutions.javafx.data.log.gvent.Gvent;
import com.etlsolutions.javafx.data.log.gvent.GventDetailValueWrapper;
import com.etlsolutions.javafx.data.log.gvent.Gvents;
import com.etlsolutions.javafx.data.log.task.CustomTask;
import com.etlsolutions.javafx.data.log.task.CustomTaskValueWrapper;
import com.etlsolutions.javafx.data.log.task.FertilisationTask;
import com.etlsolutions.javafx.data.log.task.FertilisationTaskValueWrapper;
import com.etlsolutions.javafx.data.log.task.HarvestingTask;
import com.etlsolutions.javafx.data.log.task.HarvestingTaskValueWrapper;
import com.etlsolutions.javafx.data.log.task.PlantThinningTask;
import com.etlsolutions.javafx.data.log.task.PlantThinningTaskValueWrapper;
import com.etlsolutions.javafx.data.log.task.PruningTask;
import com.etlsolutions.javafx.data.log.task.PruningTaskValueWrapper;
import com.etlsolutions.javafx.data.log.task.Task;
import com.etlsolutions.javafx.data.log.task.TaskValueWrapper;
import com.etlsolutions.javafx.data.log.task.Tasks;
import com.etlsolutions.javafx.data.log.task.TransplantTask;
import com.etlsolutions.javafx.data.log.task.TransplantTasklValueWrapper;
import com.etlsolutions.javafx.data.log.task.WaterType;
import com.etlsolutions.javafx.data.log.task.WateringTask;
import com.etlsolutions.javafx.data.log.task.WateringTaskValueWrapper;
import com.etlsolutions.javafx.data.log.task.WateringType;
import com.etlsolutions.javafx.data.log.weather.WeatherRecords;
import com.etlsolutions.gwise.system.ProjectManager;
import java.time.LocalDateTime;

/**
 *
 * @author zc
 */
public class LogFactory {

    private static final LogFactory INSTANCE = new LogFactory();

    public static LogFactory getInstance() {
        return INSTANCE;
    }

    public Notification getDefaultNotification() {

        return new Notification(30, NotificationTimeUnit.MINUTS, 1);
    }

    public LogGroupRoot createLogGroupRoot() {

        LogGroupRoot l = new LogGroupRoot();

        l.setTitle("All Records");
        l.setEvents(createEvents());
        l.setIssues(createIssues());
        l.setNotes(createNotes());
        l.setReferences(createReferences());
        l.setTasks(createTasks());
        l.setTests(createTests());
        l.setWeatherRecords(createWeatherRecords());
        return l;
    }

    public Gvents createEvents() {

        return new Gvents("Events");

    }

    public Issues createIssues() {
        return new Issues("Issues");

    }

    public Notes createNotes() {

        return new Notes("Notes");
    }

    public References createReferences() {

        return new References("References");
    }

    public Tasks createTasks() {

        return new Tasks("Tasks");
    }

    public Tests createTests() {

        return new Tests("Tests");
    }

    public WeatherRecords createWeatherRecords() {

        return new WeatherRecords("Weather");
    }

    public Gvent createGvent(DataUnitValueWrapper valueWrapper, GventDetailValueWrapper detailValueWrapper) {

        switch (detailValueWrapper.getType()) {
            case FLOWERING:
                return new FloweringGvent(valueWrapper, (FloweringGventValueWrapper) detailValueWrapper);
            case FRUITING:
                return new FruitingGvent(valueWrapper, (FruitingGventValueWrapper) detailValueWrapper);
            case CUSTOM:
                return new CustomGvent(valueWrapper, (CustomGventDetailValueWrapper) detailValueWrapper);
            default:
                throw new IllegalArgumentException("Invalid Event type.");
        }
    }

    public GrowingIssueValueWrapper createDefaultGrowingIssueValueWrapper() {

        return new GrowingIssueValueWrapper("Untitled", "", new ObservableListWrapperA<ImageLink>(), null, "", LocalDateTime.now(), LocalDateTime.now(), "", "");
    }

    public GrowingIssue createGrowingIssue(GrowingIssueValueWrapper growingIssueValueWrapper) {

        return new GrowingIssue(growingIssueValueWrapper);
    }

    public GrowingObservationValueWrapper createDefaultGrowingObservationValueWrapper() {
        return new GrowingObservationValueWrapper("Untitled", "", new ObservableListWrapperA<ImageLink>(), null, "", LocalDateTime.now(), LocalDateTime.now());
    }

    public GrowingObservation createGrowingObservation(GrowingObservationValueWrapper valueWrapper) {

        return new GrowingObservation(valueWrapper);
    }

    public FloweringGventValueWrapper createDefaultFloweringGventValueWrapper() {
        return new FloweringGventValueWrapper("Untitled", "", new ObservableListWrapperA<ImageLink>(), null, "", LocalDateTime.now(), LocalDateTime.now(), new ObservableListWrapperA<Notification>(), "Red", "Corymb", 0);
    }

    public FruitingGventValueWrapper createDefaultFruitingGventValueWrapper() {
        return new FruitingGventValueWrapper("Untitled", "", new ObservableListWrapperA<ImageLink>(), null, "", LocalDateTime.now(), LocalDateTime.now(), new ObservableListWrapperA<Notification>(), true, 0, "Red", "Rounded", 0, 0, 0);
    }

    /**
     * Basic forms are the key to a flower type’s guide.These include:
     *
     * Raceme – A raceme is a group of small stalked flowers attached to a stem
     * in an elongated cluster. Spike – Similar to raceme, a spike is an
     * elongated cluster but the flowers are stemless.
     *
     * Umbel – An umbel is an umbrella-shaped cluster of florets with pedicles
     * the same length.
     *
     * Corymb – While a corymb is shaped similarly to an umbel, it has pedicles
     * of different lengths to create a flattened top. Head – A head is a type
     * of inflorescence that resembles a solitary flower but is, in fact, made
     * up of tightly packed florets.
     *
     * Cyme – A cyme is a flat-topped cluster where the upper flowers open first
     * followed by those lower in the arrangement.
     *
     * Panicle – A panicle has a central point bearing a branched organization
     * of racemes.
     *
     * Read more at Gardening Know How: Identifying Flowers: Learn About Flower
     * Types And Inflorescences
     * https://www.gardeningknowhow.com/garden-how-to/info/flowers-and-inflorescences.htm
     *
     *
     * @return
     */
    public ObservableListWrapperA<String> getDefaultFlowerTypes() {

        String[] types = {"Corymb", "Cyme", "Panicle", "Raceme", "Spike", "Umbel"};

        return new ObservableListWrapperA<>(types);
    }

    public ObservableListWrapperA<String> getDefaultFlowerColors() {

        String[] types = {"Red", "White", "Yellow", "Blue", "Purple", "Pink", "Orange"};

        return new ObservableListWrapperA<>(types);
    }

    public ObservableListWrapperA<String> getDefaultFruitShapes() {
        String[] types = {"Rounded", "Cylindrical", "Fflattened", "Heart shaped"};

        return new ObservableListWrapperA<>(types);
    }

    public ObservableListWrapperA<String> getDefaultFruitColors() {
        String[] types = {"Red", "White", "Yellow", "Blue", "Purple", "Pink", "Orange"};

        return new ObservableListWrapperA<>(types);
    }

    public CustomTaskValueWrapper getDefaultCustomTaskValueWrapper() {
        return new CustomTaskValueWrapper("Untitled", "", new ObservableListWrapperA<ImageLink>(), null, "", LocalDateTime.now(), new ObservableListWrapperA<Notification>());
    }

    public FertilisationTaskValueWrapper getDefaultFertilisationTaskValueWrapper() {
        return new FertilisationTaskValueWrapper("Untitled", "", new ObservableListWrapperA<ImageLink>(), null, "", LocalDateTime.now(), 
                new ObservableListWrapperA<Notification>(), null, 0, ProjectManager.getInstance().getContents().getFertiliserUoms().get(0));
    }

    public HarvestingTaskValueWrapper getDefaultHarvestingTaskValueWrapper() {
        return new HarvestingTaskValueWrapper("Untitled", "", new ObservableListWrapperA<ImageLink>(), null, "", LocalDateTime.now(), new ObservableListWrapperA<Notification>(),
                ProjectManager.getInstance().getContents().getHarvestingQualities().get(0), 0, ProjectManager.getInstance().getContents().getHarvestingUoms().get(0));
    }

    public PlantThinningTaskValueWrapper getDefaultPlantThinningTaskValueWrapper() {
        return new PlantThinningTaskValueWrapper("Untitled", "", new ObservableListWrapperA<ImageLink>(), null, "", LocalDateTime.now(), new ObservableListWrapperA<Notification>(),
                0, 0);
    }

    public PruningTaskValueWrapper getDefaultPruningTaskValueWrapper() {
        return new PruningTaskValueWrapper("Untitled", "", new ObservableListWrapperA<ImageLink>(), null, "", LocalDateTime.now(), new ObservableListWrapperA<Notification>(), 0, 0);
    }

    public TransplantTasklValueWrapper getDefaultTransplantTasklValueWrapper() {
        return new TransplantTasklValueWrapper("Untitled", "", new ObservableListWrapperA<ImageLink>(), null, "", LocalDateTime.now(), new ObservableListWrapperA<Notification>(), null, null);
    }

    public WateringTaskValueWrapper getDefaultWateringTaskValueWrapper() {
        return new WateringTaskValueWrapper("Untitled", "", new ObservableListWrapperA<ImageLink>(), null, "", LocalDateTime.now(), new ObservableListWrapperA<Notification>(), 
                WateringType.USE_WATER_CAN, WaterType.RAIN_WATER,false, null, 0, ProjectManager.getInstance().getContents().getWateringAmountUoms().get(0),
                3, ProjectManager.getInstance().getContents().getWateringFluxUoms().get(0), 0);
    }

    public Task createTask(DataUnitValueWrapper commonValueWrapper, TaskValueWrapper detailValueWrapper) {
        switch (detailValueWrapper.getType()) {
            case CUSTOM:
                return new CustomTask(commonValueWrapper, (CustomTaskValueWrapper) detailValueWrapper);
            case FERTILZATION:
                return new FertilisationTask(commonValueWrapper, (FertilisationTaskValueWrapper) detailValueWrapper);
            case HARVESTING:
                return new HarvestingTask(commonValueWrapper, (HarvestingTaskValueWrapper) detailValueWrapper);
            case PLANT_THINNING:
                return new PlantThinningTask(commonValueWrapper, (PlantThinningTaskValueWrapper) detailValueWrapper);
            case PRUNING:
                return new PruningTask(commonValueWrapper, (PruningTaskValueWrapper) detailValueWrapper);
            case TRANSPLANTING:
                return new TransplantTask(commonValueWrapper, (TransplantTasklValueWrapper) detailValueWrapper);
            case WATERING:
                return new WateringTask(commonValueWrapper, (WateringTaskValueWrapper) detailValueWrapper);
            default:
                throw new IllegalArgumentException("Invalid task type.");
        }
    }

    public ObservableListWrapperA<String> getDefaultWaterAmountUoms() {
        return new ObservableListWrapperA<>("litre", "gallon");
    }

    public ObservableListWrapperA<String> getDefaultWaterFluxUoms() {
        return new ObservableListWrapperA<>("litre/minute", "gallon/minute");
    }

    public TaskValueWrapper getTaskValueWrapper(Task task) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
