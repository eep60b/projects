package com.etlsolutions.examples.weather;

import static com.etlsolutions.examples.weather.SettingConstants.*;
import com.etlsolutions.examples.weather.data.RequestConfig;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * The ApplicationParameters class contains all parameters to run the
 * application.
 *
 * @author zc
 */
public final class ApplicationParameters {

    private final String configFilePath;
    private final String dataDirectoryPath;
    private final List<RequestConfig> requestConfigs;
    private final List<String> additionalDataDirectoryPaths = new ArrayList<>();
    private final String baseDataDirectoryPath;
    private final String dataEncoding;
    private final String dataFileExtension;
    private final int intervalInMinutes;
    private final SimpleDateFormat datetimeFormat;
    private final String delimiter;
    private final boolean useFtpsService;
    private final String ftpsServerName;
    private final String ftpsUsername;
    private final String ftpsPassword;
    private final String ftpsRemoteSourceDirectory;
    private final List<String> ftpsLocalTargetDirecotries = new ArrayList<>();

    /**
     * Construct an object.
     *
     * @param configFilePath - The path to find the configuration file.
     * @param dataDirectoryPath = The path to the data directory.
     * @param requestConfigs - The request configurations.
     * @param additionalDataDirectoryPaths -
     * @param baseDataDirectoryPath
     * @param dataEncoding
     * @param dataFileExtension
     * @param intervalInMinutes
     * @param datetimeFormat
     * @param delimiter
     * @param useFtpsService
     * @param ftpsServerName
     * @param ftpsUsername
     * @param ftpsPassword
     * @param ftpsRemoteSourceDirectory
     * @param ftpsLocaTargetDirecotries
     */
    public ApplicationParameters(String configFilePath, String dataDirectoryPath, List<RequestConfig> requestConfigs, String[] additionalDataDirectoryPaths,
            String baseDataDirectoryPath, String dataEncoding, String dataFileExtension, String intervalInMinutes, String datetimeFormat, String delimiter,
            boolean useFtpsService, String ftpsServerName, String ftpsUsername, String ftpsPassword, String ftpsRemoteSourceDirectory, String[] ftpsLocaTargetDirecotries) {

        this.configFilePath = new File(configFilePath.trim()).getAbsolutePath();
        this.dataDirectoryPath = new File(dataDirectoryPath.trim()).getAbsolutePath();
        this.requestConfigs = Collections.unmodifiableList(requestConfigs);

        for (String path : additionalDataDirectoryPaths) {
            if (path != null && !path.trim().isEmpty()) {
                this.additionalDataDirectoryPaths.add(new File(path.trim()).getAbsolutePath());
            }
        }

        this.baseDataDirectoryPath = (baseDataDirectoryPath == null || baseDataDirectoryPath.trim().isEmpty()) ? "" : new File(baseDataDirectoryPath).getAbsolutePath();
        this.dataEncoding = dataEncoding.trim();
        this.dataFileExtension = dataFileExtension.trim().toLowerCase();
        this.intervalInMinutes = RecoverableIntParser.getInstance().parseNumber(intervalInMinutes, DEFAULT_INTERVAL_MINUTES, "interval in minutes");
        this.datetimeFormat = new SimpleDateFormat(datetimeFormat.trim());
        this.delimiter = delimiter;
        this.useFtpsService = useFtpsService;
        this.ftpsServerName = ftpsServerName.trim();
        this.ftpsUsername = ftpsUsername.trim();
        this.ftpsPassword = ftpsPassword.trim();
        this.ftpsRemoteSourceDirectory = ftpsRemoteSourceDirectory.trim();
        for(String path : ftpsLocaTargetDirecotries) {
            if (path != null && !path.trim().isEmpty()) {
                this.ftpsLocalTargetDirecotries.add(new File(path.trim()).getAbsolutePath());
            }
        }
    }

    /**
     * Get the absolute path to find the configuration file.
     *
     * @return the path string.
     */
    public String getConfigFilePath() {
        return configFilePath;
    }

    /**
     * Get the absolute path of data directory.
     *
     * @return the path string.
     */
    public String getDataDirectoryPath() {
        return dataDirectoryPath;
    }

    /**
     * Get the list of request configurations.
     *
     * @return the configuration list.
     */
    public List<RequestConfig> getRequestConfigs() {
        return requestConfigs;
    }

    /**
     * Get the additional paths for data directories.
     *
     * @return the path list. This list will not be null.
     */
    public List<String> getAdditionalDataDirectoryPaths() {
        return Collections.unmodifiableList(additionalDataDirectoryPaths);
    }

    /**
     * Get the path for base data directory. The base data is the previous data
     * which can be used to add new data.
     *
     * @return the path for base data.
     */
    public String getBaseDataDirectoryPath() {
        return baseDataDirectoryPath;
    }

    /**
     * Get the data encoding.
     *
     * @return the data encoding string.
     */
    public String getDataEncoding() {
        return dataEncoding;
    }

    /**
     * Get the file extension.
     *
     * @return the file extension string.
     */
    public String getDataFileExtension() {
        return dataFileExtension;
    }

    /**
     * Get the interval time to retrieve the data (in minutes).
     *
     * @return the interval time
     */
    public int getIntervalInMinutes() {
        return intervalInMinutes;
    }

    /**
     * Get the date format used for the data.
     *
     * @return the date format.
     */
    public DateFormat getDatetimeFormat() {
        return datetimeFormat;
    }

    /**
     * Get the delimiter which separates the fields in the data row.
     *
     * @return the delimiter string.
     */
    public String getDelimiter() {
        return delimiter;
    }

    /**
     * The name of the server where the data files can be downloaded via FTPS.
     *
     * @return the server name.
     */
    public String getFtpsServerName() {
        return ftpsServerName;
    }

    /**
     * The username which can be used to retrieve via FTPS.
     *
     * @return the user name.
     */
    public String getFtpsUsername() {
        return ftpsUsername;
    }

    /**
     * Get the password for the user in the FTP server.
     * @return
     */
    public String getFtpsPassword() {
        return ftpsPassword;
    }

    /**
     *
     * @return
     */
    public String getFtpsRemoteSourceDirectory() {
        return ftpsRemoteSourceDirectory;
    }

    /**
     * Get the location where the data files should be downloaded from the
     * server via FTPS.
     *
     * @return
     */
    public List<String> getFtpsLocalTargetDirecotries() {
        return Collections.unmodifiableList(ftpsLocalTargetDirecotries);
    }

    /**
     * Check if the FTPS service should be run.
     *
     * @return
     */
    public boolean isUseFtpsService() {
        return useFtpsService;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.configFilePath);
        hash = 59 * hash + Objects.hashCode(this.dataDirectoryPath);
        hash = 59 * hash + Objects.hashCode(this.requestConfigs);
        hash = 59 * hash + Objects.hashCode(this.additionalDataDirectoryPaths);
        hash = 59 * hash + Objects.hashCode(this.baseDataDirectoryPath);
        hash = 59 * hash + Objects.hashCode(this.dataEncoding);
        hash = 59 * hash + Objects.hashCode(this.dataFileExtension);
        hash = 59 * hash + this.intervalInMinutes;
        hash = 59 * hash + Objects.hashCode(this.datetimeFormat);
        hash = 59 * hash + Objects.hashCode(this.delimiter);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final ApplicationParameters other = (ApplicationParameters) obj;
        if (!Objects.equals(this.configFilePath, other.configFilePath)) {
            return false;
        }
        if (!Objects.equals(this.dataDirectoryPath, other.dataDirectoryPath)) {
            return false;
        }
        if (!Objects.equals(this.requestConfigs, other.requestConfigs)) {
            return false;
        }
        if (!Objects.equals(this.additionalDataDirectoryPaths, other.additionalDataDirectoryPaths)) {
            return false;
        }
        if (!Objects.equals(this.baseDataDirectoryPath, other.baseDataDirectoryPath)) {
            return false;
        }
        if (!Objects.equals(this.dataEncoding, other.dataEncoding)) {
            return false;
        }
        if (!Objects.equals(this.dataFileExtension, other.dataFileExtension)) {
            return false;
        }
        if (this.intervalInMinutes != other.intervalInMinutes) {
            return false;
        }
        if (!Objects.equals(this.datetimeFormat, other.datetimeFormat)) {
            return false;
        }
        return Objects.equals(this.delimiter, other.delimiter);
    }

    @Override
    public String toString() {

        String mainString = "Configuration file =           " + configFilePath + "\n"
                + "Request configs =              " + requestConfigs + "\n"
                + "Data file directory =          " + dataDirectoryPath + "\n"
                + "Addtional data directory =     " + additionalDataDirectoryPaths + "\n"
                + "Base data directory =          " + baseDataDirectoryPath + "\n"
                + "Data encoding  =               " + dataEncoding + "\n"
                + "Data file extension  =         " + dataFileExtension + "\n"
                + "Interval in minutes  =         " + intervalInMinutes + "\n"
                + "Date time format =             " + datetimeFormat.toLocalizedPattern() + "\n"
                + "Delimiter =                    [" + delimiter + "]" + "\n"
                + "Use FTPS service =             " + useFtpsService;

        String useFptsString = mainString + "\n"
                + "FTPS Server name =             " + ftpsServerName + "\n"
                + "FTPS Username =                " + ftpsUsername + "\n"
                + "FTPS Remote Source Directory = " + ftpsRemoteSourceDirectory + "\n"
                + "FTPS Local Target Direcotry =  " + ftpsLocalTargetDirecotries;

        return useFtpsService ? useFptsString : mainString;
    }
}
