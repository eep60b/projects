package com.etlsolutions.examples.weather;

import static com.etlsolutions.examples.weather.SettingConstants.*;
import com.etlsolutions.examples.weather.data.RequestMethod;
import com.etlsolutions.examples.weather.data.RequestConfig;
import com.etlsolutions.examples.weather.data.RequestLocation;
import com.etlsolutions.examples.weather.data.RequestToken;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

/**
 * The RequestConfigLoader class loads the request resources from disk.
 *
 * @author zc
 */
public final class RequestConfigLoader {

    private static final RequestConfigLoader INSTANCE = new RequestConfigLoader();

    private RequestConfigLoader() {
    }

    /**
     *
     * @return the singleton instance of this class.
     */
    public static final RequestConfigLoader getInstance() {
        return INSTANCE;
    }

    /**
     *
     * @param resourcePropertiesFilesPath
     * @param requestLocationsPath
     * @return
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     */
    @SuppressWarnings("NestedAssignment")
    public List<RequestConfig> load(String resourcePropertiesFilesPath, String requestLocationsPath) throws ParserConfigurationException, SAXException, IOException {

        Logger logger = Logger.getLogger(RequestConfigLoader.class);

        List<RequestLocation> locations = RequestLocationsLoader.getInstance().load(requestLocationsPath, DEFAULT_REQUEST_LOCATIONS_FILE_PATH, EMBEDDED_REQUEST_LOCATIONS_FILE_PATH);

        List<Properties> propertieses = new ArrayList<>();
        List<RequestConfig> list = new ArrayList<>();

        File resourcePropertiesFiles = new File(resourcePropertiesFilesPath);

        if (resourcePropertiesFiles.isFile()) {

            logger.info("\nTry to load request configurations from " + resourcePropertiesFiles.getAbsolutePath() + ".");
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(resourcePropertiesFiles);
            properties.load(fileInputStream);
            propertieses.add(properties);
            logger.info("The request configurations have been loaded successfully from " + resourcePropertiesFiles.getAbsolutePath() + ".");

        } else if (resourcePropertiesFiles.isDirectory()) {

            File[] files = resourcePropertiesFiles.listFiles();
            for (File file : files) {
                if (file.getName().endsWith(RESOURCES_PROPERTIES_FILE_EXTENSION)) {
                    logger.info("\nTry to load request configurations from " + file.getAbsolutePath() + ".");
                    Properties properties = new Properties();
                    properties.load(new FileInputStream(file));
                    propertieses.add(properties);
                    logger.info("The request configurations have been loaded successfully from " + file.getAbsolutePath() + ".");
                }
            }
        } else {

            List<String> filenames = new ArrayList<>();

            logger.warn("\nThe request configuration file path " + resourcePropertiesFiles.getAbsolutePath() + " does not exist.");
            logger.info("Try to find request configuration files from the embedded directory.");

            EmbeddedInputStreamProvider provider = EmbeddedInputStreamProvider.getInstance();
            try (InputStream inputStream = provider.getInputStream(EMBEDDED_REQUEST_CONFIG_DIRECTORY_PATH);
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                    BufferedReader br = new BufferedReader(inputStreamReader)) {

                String filename;
                while ((filename = br.readLine()) != null) {
                    filenames.add(filename);
                }
            }

            logger.info("Request configuration files founded: " + filenames + ".");

            for (String filename : filenames) {
                logger.info("Try to load request configurations from the embedded file " + filename + ".");
                String path = EMBEDDED_REQUEST_CONFIG_DIRECTORY_PATH + "/" + filename;
                if (filename.toLowerCase().trim().endsWith(".properties")) {
                    Properties properties = new Properties();
                    properties.load(provider.getInputStream(path));
                    propertieses.add(properties);
                    logger.info("The request configurations has been successfully loaded from the embedded file " + filename + ".");
                    File file = new File(resourcePropertiesFilesPath + "/" + filename);
                    try {
                        FileUtils.copyInputStreamToFile(provider.getInputStream(path), file);
                        logger.info("The request location file " + filename + " has been copied to " + file.getAbsolutePath() + ".");
                    } catch (IOException ioe) {
                        logger.warn("Failed to copy the request location file " + filename + " to " + file.getAbsolutePath() + ".", ioe);
                    }
                }
            }
        }

        if (propertieses.isEmpty()) {
            String message = "There is no valid configuration found.";
            logger.error(message);
            throw new IOException(message);
        }

        propertieses.stream().map((properties) -> {
            String locationId = properties.getProperty(LOCATION_TOKEN);
            RequestLocation location = getRequestLocation(locationId, locations);
            RequestMethod requesttMethod = RequestMethod.getRequesttMethod(properties.getProperty(REQUEST_METHOD_TOKEN), properties.getProperty(REQUEST_INTERVAL_TOKEN));
            RequestToken requestToken = new RequestToken(properties.getProperty(REQUEST_TOEKN));
            RequestConfig requestConfig = new RequestConfig(requesttMethod, location, requestToken);
            return requestConfig;
        }).forEach((requestConfig) -> {
            list.add(requestConfig);
        });

        logger.info("\n" + list.size() + " sets of request configurations have been loaded successfully.");
        return Collections.unmodifiableList(list);
    }

    private RequestLocation getRequestLocation(String locationId, List<RequestLocation> locations) {

        for (RequestLocation location : locations) {
            if (location.getId().equals(locationId)) {
                return location;
            }
        }

        throw new IllegalArgumentException("Invald location ID: " + locationId);
    }
}
