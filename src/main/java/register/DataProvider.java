package register;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import static utilities.utilityMethods.*;

public class DataProvider {
    public static AppiumDriver<MobileElement> APPIUM_DRIVER;
    public static Properties APP_LOCATOR_VALUES, UTILITY_OBJECTS;
    public static String USER_PATH = System.getProperty("user.dir"),
                        APP_PATH = "//src//test//resources//app//nopstationCart.apk",
                        APP_LOCATOR_PATH = "locatorValues//",
                        EXCEL_SHEET_FILE_PATH = USER_PATH + "//src//test//resources//testDataResources//",
                        EXCEL_SHEET_FILE_NAME = "DataForGroupActionSet.xlsx",
                        APP_LOCATOR_FILE_NAME = "appLocatorValues",
                        UTILITY_OBJECTS_FILE_NAME = "utilityObjects",
                        PLATFORM_NAME = "Android",
                        DEVICE_NAME = "emulator-5554",
                        APP = USER_PATH + APP_PATH,
                        APP_PACKAGE = "com.nopstation.nopcommerce.nopstationcart",
                        APP_ACTIVITY = "com.bs.ecommerce.main.SplashScreenActivity",
                        APPIUM_SERVER_URL = "http://127.0.0.1:4723/wd/hub",
                        DATE_TIME = currentDateAndTimeGet("yyyy-MM-dd hh:mm:ss a").replace(":", " ").replace(" ", "-");
    public static int MAX_WAIT_TIME = 30;
    public static Map<String, List<LinkedHashMap<String, String>>> excelSheetList = new LinkedHashMap<>();
}
