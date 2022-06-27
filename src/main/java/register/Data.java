package register;

import utilities.PropertyUtils;
import utilities.Utils;

import java.util.*;

public class Data {
    private static HashMap<PropertyFile, Properties> LIST_OF_ALL_PROPERTIES = new HashMap<>();;
    private static Map<String, List<LinkedHashMap<String, String>>> excelSheetMap = new LinkedHashMap<>();
    private static final String USER_PATH = System.getProperty("user.dir"),
                                CONFIG_FILE_PATH = "config//",
                                CONFIG_FILE_NAME = "configuration";

    static Properties configFile = PropertyUtils.getProperties(CONFIG_FILE_PATH, CONFIG_FILE_NAME);
    private static final int DEFAULT_MAX_WAIT_TIME = Integer.parseInt(configFile.getProperty("default_max_wait_time"));
    private static final String APP_PATH = configFile.getProperty("application_path"),
                        APP_LOCATOR_PATH = configFile.getProperty("application_locator_path"),
                        EXCEL_SHEET_FILE_PATH = USER_PATH + configFile.getProperty("excel_sheet_file_path"),
                        EXCEL_SHEET_FILE_NAME = configFile.getProperty("excel_sheet_file_name"),
                        APP_LOCATOR_FILE_NAME = configFile.getProperty("application_locator_file_name"),
                        UTILITY_OBJECTS_FILE_NAME = configFile.getProperty("utility_objects_file_name"),
                        PLATFORM_NAME = configFile.getProperty("platform_name"),
                        DEVICE_NAME = configFile.getProperty("device_name"),
                        APP = USER_PATH + APP_PATH,
                        APP_PACKAGE = configFile.getProperty("application_package"),
                        APP_ACTIVITY = configFile.getProperty("application_activity"),
                        APPIUM_SERVER_URL = configFile.getProperty("appium_server_url"),
                        DATE_TIME = Utils.getCurrentDateAndTime("yyyy-MM-dd hh:mm:ss a").replace(":", " ").replace(" ", "-");

    public static HashMap<PropertyFile, Properties> getListOfAllProperties() {
        return LIST_OF_ALL_PROPERTIES;
    }

    public static Map<String, List<LinkedHashMap<String, String>>> getExcelSheetMap() {
        return excelSheetMap;
    }

    public static int getDefaultMaxWaitTime() {
        return DEFAULT_MAX_WAIT_TIME;
    }

    public static String getUserPath() {
        return USER_PATH;
    }

    public static String getAppLocatorPath() {
        return APP_LOCATOR_PATH;
    }

    public static String getExcelSheetFilePath() {
        return EXCEL_SHEET_FILE_PATH;
    }

    public static String getExcelSheetFileName() {
        return EXCEL_SHEET_FILE_NAME;
    }

    public static String getAppLocatorFileName() {
        return APP_LOCATOR_FILE_NAME;
    }

    public static String getUtilityObjectsFileName() {
        return UTILITY_OBJECTS_FILE_NAME;
    }

    public static String getPlatformName() {
        return PLATFORM_NAME;
    }

    public static String getDeviceName() {
        return DEVICE_NAME;
    }

    public static String getAPP() {
        return APP;
    }

    public static String getAppPackage() {
        return APP_PACKAGE;
    }

    public static String getAppActivity() {
        return APP_ACTIVITY;
    }

    public static String getAppiumServerUrl() {
        return APPIUM_SERVER_URL;
    }

    public static String getDateTime() {
        return DATE_TIME;
    }
}
