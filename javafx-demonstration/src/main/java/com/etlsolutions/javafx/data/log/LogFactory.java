package com.etlsolutions.javafx.data.log;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.log.gvent.Gvents;
import com.etlsolutions.javafx.data.log.task.PruningTaskDetail;
import com.etlsolutions.javafx.data.log.task.Task;
import com.etlsolutions.javafx.data.log.task.TaskDetail;
import com.etlsolutions.javafx.data.log.task.TaskType;
import com.etlsolutions.javafx.data.log.task.Tasks;
import com.etlsolutions.javafx.data.log.task.WaterType;
import com.etlsolutions.javafx.data.log.task.WateringTaskDetail;
import com.etlsolutions.javafx.data.log.task.WateringType;
import com.etlsolutions.javafx.data.log.weather.WeatherRecords;
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

        return new Gvents("Events", "");

    }

    public Issues createIssues() {
        return new Issues("Issues", "");

    }

    public Notes createNotes() {

        return new Notes("Notes", "");
    }

    public References createReferences() {

        return new References("References", "");
    }

    public Tasks createTasks() {

        return new Tasks("Tasks", "");
    }

    public Tests createTests() {

        return new Tests("Tests", "");
    }

    public WeatherRecords createWeatherRecords() {

        return new WeatherRecords("Weather", "");
    }

    public GrowingIssue createGrowingIssue(DataUnitValueWrapper valueWrapper, GrowingIssueValueWrapper growingIssueValueWrapper) {

        return new GrowingIssue(valueWrapper, growingIssueValueWrapper);
    }

    public GrowingObservation createGrowingObservation(DataUnitValueWrapper valueWrapper, LocalDateTime startTime, LocalDateTime endTime) {

        return new GrowingObservation(valueWrapper, startTime, endTime);
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
    
    public  PruningTaskDetail getDefaultPruningTaskDetail() {
        return new PruningTaskDetail(25, 25);
    }

    public Task createTask(DataUnitValueWrapper commonValueWrapper, TaskType value, ObservableListWrapperA<Notification> notifications, TaskDetail detail) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public WateringTaskDetail getDefaultWateringTaskDetail() {
        return new WateringTaskDetail(WateringType.USE_WATER_CAN, WaterType.TAP_WATER, false, null, 1.0, getDefaultWaterAmountUoms().get(0), 
                1.0, getDefaultWaterFluxUoms().get(0), 3);
    }
    
    public ObservableListWrapperA<String> getDefaultWaterAmountUoms() {
        return new ObservableListWrapperA<>("litre", "gallon");
    }
    
    public ObservableListWrapperA<String> getDefaultWaterFluxUoms() {
        return new ObservableListWrapperA<>("litre/minute", "gallon/minute");
    }
}
