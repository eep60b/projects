package com.etlsolutions.javafx.system;

import java.io.File;
import java.util.Locale;

/**
 *
 * @author zc
 */
public class SettingConstants {

    /**
     * **************************** Keys *****************************************
     */
    /**
     * Find the next item ID. An item ID is a unique number. It is sequentially generated and will not be reused once the item is deleted.
     */
    public static final String NEXT_ITEM_ID_KEY = "next.item.id";

    public static final String DEFAULT_DATAUNIT_TITLE_BUNDLE_KEY = "com.etlsolutions.javafx.data.common.untitled";

    public static final String CURRENT_RPOJECT_PATH_KEY = "current.project.path";

    /**
     * **************************** Constants ************************************
     */

    /**
     * The user home.
     */
    public static final String USER_HOME = System.getProperty("user.home");
    /**
     * The repository location contains configuration information for current user. 1) The latest opened project. 2) The recent opened project. 3) The default export path. 4) The default printer. 5)
     * The default import path.
     */
    public static final String REPOSITORY_LOCATION = USER_HOME + File.separator + ".gardenwise";

    /**
     * The default image folder in user home.
     */
    public static final String DEFAULT_IMAGE_DIRECTORY = USER_HOME + File.separator + "Pictures";

    /**
     * The path to find the configuration file for projects.
     */
    public static final String REPOSITORY_CONFIG_FILE_PATH = REPOSITORY_LOCATION + File.separator + "config.properties";

    
    public static final String BUNDLE_SEPARATER = ",";
    
    /**
     *
     */
    public static final String DATAUNIT_BUNDLE_PATH = "com/etlsolutions/javafx/data/DataUnit";
    
    /**
     * 
     */
    public static final String ACTION_EVENT_BUNDLE_PATH = "com/etlsolutions/javafx/presentation/AcitionEvent";    
    

    /**
     * **************************** Constants ************************************
     */
    /**
     * This is used in this application when file names needs separation for words.
     */
    public static final String FILE_NAME_SEPERATOR = "_";

    
    public static final int DATA_UNIT_ID_BASE = 1000;    
    /**
     * This extension is used for all JSON file in this application. The system should NOT de-serialise any file without this extension.
     */
    public static final String JSON_FILE_EXTENSION = ".json";

    /**
     * This extension is used for all JSON file in this application. The system should NOT de-serialise any file without this extension.
     */
    public static final String PROJECT_CONTENTS_JSON_FILE_EXTENSION = "project_contents.json";    
    /**
     * ********************************* Default values *************************
     *
     */
    public static final int DEFAULT_LOCATION_ID = 35;
    
    
    public static final String LANGUAGE = Locale.getDefault().getLanguage();
    
    public static final String DEFAULT_DATA_DIRECTORY = "src/main/resources/data/json/" + LANGUAGE;
    
    public static final String DEFALUT_SUPPORT_INFORMATION_DIRECTORY = "src/main/resources/support/data/" + LANGUAGE + "/information";
    
    
    /**
     * ********************************* Other constants *************************
     */
    
    public static final double PI = 3.14159265;
}
