package com.etlsolutions.javafx.system;

import java.io.File;

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

    /**
     *
     */
    public static final String DATAUNIT_BUNDLE_PATH = "com/etlsolutions/javafx/data/DataUnit";

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
     * ********************************* Default values *************************
     *
     */
    

    
    public static final int DEFAULT_LOCATION_ID = 35;
}
