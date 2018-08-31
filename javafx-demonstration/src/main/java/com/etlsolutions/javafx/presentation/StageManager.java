package com.etlsolutions.javafx.presentation;

import java.util.HashMap;
import java.util.Map;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

/**
 *
 * @author zc
 */
public class StageManager {
    
    public static final String NEW_PROJECT_DIALOG_STAGE = "com.etlsolutions.javafx.presentation.NEW_PROJECT_DIALOG_STAGE";
    
    private static final StageManager INSTANCE = new StageManager();
    
    private final Map<String, Stage> map = new HashMap<>();
    
    private StageManager() {        
    }
    
    public static final StageManager getInstance() {
        return INSTANCE;
    }
    
    public void putStage(String key, Stage stage) {
        map.put(key, stage);
    }
    
    public void closeAndRemove(String key) {
        Stage stage = map.get(key);
        if(stage == null) {
            StackTraceElement[] elements = Thread.currentThread().getStackTrace();
            StringBuilder builder = new StringBuilder();
            builder.append("An empty call occured from: \n");
            for(StackTraceElement element: elements) {
                builder.append(element.getClassName()).append(".").append(element.getMethodName()).append("(").append(element.getLineNumber()).append(")");
            }
            Logger.getLogger(getClass()).warn(new String(builder));
            return;
        }
        
        stage.close();
        map.remove(key);
    }
    
    
    public void closeNotRemove(String key) {
        Stage stage = map.get(key);
        if(stage == null) {
            return;
        }
        
        stage.close();
    }    
}
