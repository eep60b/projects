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

  /**
   * **************************** Constants ************************************
   */
  /**
   * The repository location contains configuration information for current user. 1) The latest opened project. 2) The recent opened project. 3) The default export path. 4) The default printer. 5) The
   * default import path.
   */
  public static final String REPOSITORY_LOCATION = System.getProperty("user.home") + File.separator + ".gardenwise";

  /**
   * This is used in this application when file names needs separation for words.
   */
  public static final String FILE_NAME_SEPERATOR = "_";

  public static final String JSON_FILE_EXTENSION = ".json";
}
