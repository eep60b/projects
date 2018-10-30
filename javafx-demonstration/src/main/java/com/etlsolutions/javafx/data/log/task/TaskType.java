package com.etlsolutions.javafx.data.log.task;

/**
 *
 * @author Zhipeng
 */
public enum TaskType {

    CUSTOM("Other task"), FERTILZATION("Add fertiliser"), HARVESTING("Harvesting"), PLANT_THINNING("Plant thinning"),
    PRUNING("Pruning"), TRANSPLANTING("Transplanting"), WATERING("Watering");
    
    private final String displayString;
    
    private TaskType(String displayString) {
       this.displayString = displayString; 
    }

    @Override
    public String toString() {
        return displayString;
    }
    
    
}
