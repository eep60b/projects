package com.etlsolutions.gwise.system;

import java.io.File;
import java.util.Locale;

/**
 *
 * @author zc
 */
public class SettingConstants {

    /**
     * **************************** Keys
     * *****************************************
     */
    /**
     * Find the next item ID. An item ID is a unique number. It is sequentially
     * generated and will not be reused once the item is deleted.
     */
    public static final String NEXT_ITEM_ID_KEY = "next.item.id";

    public static final String DEFAULT_DATAUNIT_TITLE_BUNDLE_KEY = "com.etlsolutions.javafx.data.common.untitled";

    public static final String CURRENT_RPOJECT_PATH_KEY = "current.project.path";

    public static final String OPEN_IMAGE_DIRECTORY_NAME_KEY = "open.image.directory.name";

    /**
     * **************************** Constants
     * ************************************
     */
    /**
     * The user home.
     */
    public static final String USER_HOME = System.getProperty("user.home");
    /**
     * The repository location contains configuration information for current
     * user. 1) The latest opened project. 2) The recent opened project. 3) The
     * default export path. 4) The default printer. 5) The default import path.
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

    public static final String REPOSITORY_DATA_CONFIG_FILE_PATH = "config/repository-data.xml";

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
     * **************************** Constants
     * ************************************
     */
    /**
     * This is used in this application when file names needs separation for
     * words.
     */
    public static final String FILE_NAME_SEPERATOR = "_";

    public static final int DATA_UNIT_ID_BASE = 1000;
    /**
     * This extension is used for all JSON file in this application. The system
     * should NOT de-serialise any file without this extension.
     */
    public static final String JSON_FILE_EXTENSION = ".json";

    public static final String PNG_FILE_EXTENSION = ".png";

    /**
     * The project contents file.
     */
    public static final String PROJECT_CONTENTS_JSON_FILE = "project_contents.json";

    /**
     * ***** Default values ***** *
     *
     */
    public static final int DEFAULT_LOCATION_ID = 35;

    public static final String LANGUAGE = Locale.getDefault().getLanguage();

    public static final String DEFAULT_DATA_DIRECTORY = "src/main/resources/data/json/" + LANGUAGE;     //This needs to be changed to use relative directories.

    public static final String DEFALUT_SUPPORT_INFORMATION_DIRECTORY = "src/main/resources/support/data/" + LANGUAGE + "/information";    //This needs to be changed.

    public static final String RELATIVE_DATA_DIRECTORY = "data";

    public static final String REPOSITORY_LOCATION_DATA = REPOSITORY_LOCATION + File.separator + RELATIVE_DATA_DIRECTORY;

    private static final String RELATIVE_JSON_DIRECTORY = RELATIVE_DATA_DIRECTORY + File.separator + "json" + File.separator + LANGUAGE;

    public static final String REPOSITORY_DATA_DIRECTORY = REPOSITORY_LOCATION + File.separator + RELATIVE_DATA_DIRECTORY;

    public static final String REPOSITORY_JSON_DIRCTORY = REPOSITORY_LOCATION + File.separator + RELATIVE_JSON_DIRECTORY;

    private static final String LOGO_DIRECTORY = REPOSITORY_LOCATION_DATA + File.separator + "logo";

    public static final String PLANT_BED_LOGO_DIRECTORY = LOGO_DIRECTORY + File.separator + "area" + File.separator + "subarea" + File.separator + "plant-bed";

    public static final String RAISED_PLANT_BED_LOGO_DIRECTORY = LOGO_DIRECTORY + File.separator + "area" + File.separator + "subarea" + File.separator + "raised-plant-bed";

    public static final String LAWN_LOGO_DIRECTORY = LOGO_DIRECTORY + File.separator + "area" + File.separator + "subarea" + File.separator + "lawn";

    public static final String POND_LOGO_DIRECTORY = LOGO_DIRECTORY + File.separator + "area" + File.separator + "subarea" + File.separator + "pond";

    public static final String GREENHOUSE_LOGO_DIRECTORY = LOGO_DIRECTORY + File.separator + "area" + File.separator + "subarea" + File.separator + "greenhouse";

    public static final String ROOM_LOGO_DIRECTORY = LOGO_DIRECTORY + File.separator + "area" + File.separator + "subarea" + File.separator + "room";

    public static final int DEFAULT_IMG_WIDTH = 100;

    public static final int DEFAULT_IMG_HEIGHT = 100;

    public static final String IMAGE_DIRECTORY_PREFIX = "gwiseimage";

    public static final int IMAGE_DIRECTORY_SIZE = 500;

    /**
     * ********************************* Fixed values and other constants
     * *************************
     */
    public static final double PI = 3.14159265;

    public static final double ANCHOR_POINT_DIAMETER = 10;
}
