package com.etlsolutions.examples.weather;

import java.io.File;

/**
 * The SettingConstants class contains all constants used in this application.
 *
 * @author zc
 */
public final class SettingConstants {

    /**
     * The field with _KEY extensions are configuration keys defined in this
     * application.
     */
    /**
     * The key to find the application user home.
     *
     */
    public static final String APPLICATION_USERHOME_KEY = "metweather.home";

    /**
     * The key to find the configuration file.
     */
    public static final String CONFIG_FILE_PATH_KEY = "configFilePath";

    /**
     * The key to find the data directory.
     */
    public static final String DATA_DIRECTORY_PATH_KEY = "dataDirectoryPath";

    /**
     * The key to find the additional data directories.
     */
    public static final String ADDITIONAL_DATA_PATH_KEY = "additionalDataPath";

    /**
     * The key to find the base data.
     */
    public static final String BASE_DATA_PATH_KEY = "baseDataPath";

    /**
     * The key to find the data encoding.
     */
    public static final String DATA_ENCODING_KEY = "dataEncoding";

    /**
     * The key to find the data file extension.
     */
    public static final String DATA_FILE_EXTENSION_KEY = "dataFileEtension";

    /**
     * The key to find the interval time in minutes to separate two data
     * retrievals.
     */
    public static final String INTERVAL_MINUTES_KEY = "intervalMinutes";

    /**
     * The key to find the request file location.
     */
    public static final String REQUEST_LOCATIONS_FILE_PATH_KEY = "requestLocationFilePath";

    /**
     * The key to find the resource properties file location.
     */
    public static final String RESOURCE_PROPERTIES_FILE_PATH_KEY = "resourcePropertiesFilePath";

    /**
     * The key to find datetime format.
     */
    public static final String DATETIME_FORMAT_KEY = "datetimeFormat";

    /**
     * The key to find the data delimiter.
     */
    public static final String DELIMITER_KEY = "delimiter";

    /**
     * The key to find if the FTPS should be switched on.
     */
    public static final String USE_FTPS_SERVICE_KEY = "useFtpsService";

    /**
     * The key to find the FTPS server name.
     */
    public static final String FTPS_SERVER_NAME_KEY = "ftpsServerName";

    /**
     *
     */
    public static final String FTPS_USERNAME_KEY = "ftpsUsername";

    /**
     *
     */
    public static final String FTPS_PASSWORD_KEY = "ftpsPassword";

    /**
     *
     */
    public static final String FTPS_REMOTE_SOURCE_DIRECTORY_KEY = "ftpsRemoteSourceDirectory";

    /**
     * The key to find the target directories to save the retrieved FTPS files. 
     */
    public static final String FTPS_LOCAL_TARGET_DIRECTORY_KEY = "ftpsLocalTargetDirectories";
    
    /**
     *
     */
    public static final String REQUEST_METHOD_TOKEN = "requestMethodToken";

    /**
     *
     */
    public static final String LOCATION_TOKEN = "locationID";

    /**
     *
     */
    public static final String REQUEST_INTERVAL_TOKEN = "requestIntervalToken";

    /**
     *
     */
    public static final String REQUEST_TOEKN = "requestToken";

    /**
     *
     */
    public static final String DEFAULT_APPLICATION_LOGHOME = "/tmp/metdata/log";

    //Use the target directory if it exists. The direcory exists only when it is in the develop mode.
    private static final String TARGET_DIRECTORY_NAME = "target";

    /**
     * The location of application home.
     */
    public static final String APPLICATION_HOME = new File(TARGET_DIRECTORY_NAME).isDirectory() ? TARGET_DIRECTORY_NAME : ".";

    /**
     * The default configuration file path.
     */
    public static final String DEFAULT_CONFIG_FILE_PATH = APPLICATION_HOME + File.separator + "props" + File.separator + "config.properties";

    /**
     * The default location for data.
     */
    public static final String DEFAULT_DATA_DIRECTORY_PATH = APPLICATION_HOME + File.separator + "metdata";

    /**
     * The additional data locations where the data will be saved.
     */
    public static final String DEFAULT_ADDITIONAL_DATA_PATH = "";

    /**
     * The base data locations.
     *
     * The base data is the data which will be copied to the data directory if
     * they are newer than those inside the data directory.
     */
    public static final String DEFAULT_BASE_DATA_PATH = "";

    /**
     * The default time zone is GMT-0:00.
     */
    public static final String DEFAULT_TIMEZONE = "GMT-0:00";

    /**
     * The default format (MM/dd/yyyy HH:mm:ss) for the data and time. This
     * format is valid for the Igor program.
     *
     * Example: 22/11/2017 15:00:00
     */
    public static final String DEFAULT_DATETIME_FORMAT = "MM/dd/yyyy HH:mm:ss";

    /**
     * The default delimiter to separate data cells.
     */
    public static final String DEFAULT_DELIMITER = ",";

    /**
     * The default data encoding is ASCII.
     */
    public static final String DEFAULT_DATA_ENCODING = "ASCII";

    /**
     * The default data file extension which is ".dat".
     */
    public static final String DEFAULT_DATA_FILE_EXTENSION = ".dat";

    /**
     * The text file extension.
     */
    public static final String TEXT_FILE_EXTENSION = ".txt";

    /**
     * The default interval to retrieve data.
     */
    public static final String DEFAULT_INTERVAL_MINUTES = "30";

    /**
     * The default path to the file to find locations that the data broadcasts
     * for.
     */
    public static final String DEFAULT_REQUEST_LOCATIONS_FILE_PATH = DEFAULT_DATA_DIRECTORY_PATH + File.separator + "locations" + File.separator + "request-locations.xml";

    /**
     * The default path to the XML file which stores weather observation station
     * locations.
     */
    public static final String DEFAULT_STATION_LOCATIONS_FILE_PATH = DEFAULT_DATA_DIRECTORY_PATH + File.separator + "locations" + File.separator + "station-locations.xml";

    /**
     *
     */
    public static final String DEFAULT_RESORUCE_PROPERTIES_FILE_PATH = APPLICATION_HOME + File.separator + "props/resources";

    /**
     * The default latitude is the latitude of our home.
     */
    public static final double DEFAULT_LATITUDE = 53.214571;

    /**
     * The default latitude is the longitude of our home.
     */
    public static final double DEFAULT_LONGITUDE = -4.151543;

    /**
     *
     */
    public static final String DEFAULT_FTPS_SERVER_NAME = "dev.etlsolutions.com";

    /**
     *
     */
    public static final String DEFAULT_FTPS_USERNAME = "zc";

    /**
     *
     */
    public static final String DEFAULT_FTPS_PASSWORD = "huan0418";

    /**
     *
     */
    public static final String DEFAULT_FTPS_REMOTE_SOURCE_DIRECTORY = "/tmp/metdata";

    /**
     *
     */
    public static final String DEFAULT_FTPS_LOCAL_TARGET_DIRECTORY = DEFAULT_DATA_DIRECTORY_PATH + File.separator + "metdata-linux";

    /**
     * The URL base which used to retrieve data after the tokens substitute by
     * the valid values.
     *
     * Examples:
     * http://datapoint.metoffice.gov.uk/public/data/val/wxobs/all/xml/3302?res=hourly&key=8412a27d-b855-4b0c-8b2d-b8b8f5285ae8
     * http://datapoint.metoffice.gov.uk/public/data/val/wxfcs/all/xml/350235?res=3hourly&key=8412a27d-b855-4b0c-8b2d-b8b8f5285ae8
     *
     */
    public static final String URL_BASE = "http://datapoint.metoffice.gov.uk/public/data/val/requestMethodToken/all/xml/locationID?res=requestIntervalToken&key=requestToken";

    /**
     *
     */
    public static final String RESOURCES_PROPERTIES_FILE_EXTENSION = ".properties";

    /**
     *
     */
    public static final String EMBEDDED_REQUEST_LOCATIONS_FILE_PATH = "/metdata/locations/request-locations.xml";

    /**
     *
     */
    public static final String EMBEDDED_STATION_LOCATIONS_FILE_PATH = "/metdata/locations/station-locations.xml";

    /**
     *
     */
    public static final String EMBEDDED_REQUEST_CONFIG_DIRECTORY_PATH = "/props/resources";

    /**
     * According to the locations data, the maximum length of a location ID is
     * 6.
     */
    public static final int MAXIMUM_LOCATION_ID_LENGTH = 6;

    /**
     * The time which a thread to be put into sleep.
     */
    public static final long THREAD_SLEEP_TIME = 60000L;

    /**
     * The dealy time which FTPS service used to start.
     */
    public static final long FTPS_START_DELAY_TIME = 10000L;

    /**
     * The encoding of the web site.
     */
    public static final String WEBSITE_ENCODING = "UTF-8";

    /**
     * The separator used in the data filename.
     */
    public static final String DATA_FILENAME_SEPARATOR = "-";

    /**
     *
     */
    public static final String DATA_XMLFILE_NODENAME_SITE_REP = "SiteRep";

    /**
     *
     */
    public static final String DATA_XMLFILE_NODENAME_DV = "DV";

    /**
     *
     */
    public static final String DATA_XMLFILE_NODENAME_LOCATION = "Location";

    /**
     *
     */
    public static final String DATA_XMLFILE_NODENAME_VALUE = "value";

    /**
     * The delay time which a thread to be join the main thread.
     */
    public static final long THREAD_JOIN_DELAY_TIME = 1000L;

    /**
     * The private constructor shouldn't be called at any time.
     *
     * @throws UnsupportedOperationException if this is called.
     */
    private SettingConstants() {
        throw new UnsupportedOperationException("This private constructor should not be initialized.");
    }
}
