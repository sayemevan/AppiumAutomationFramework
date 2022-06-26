package register;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.util.*;

import static utilities.Utils.*;

public class Data {
    public static AndroidDriver<MobileElement> ANDROID_DRIVER;
    public static String[] nameOfPropertyFiles = { "APP_LOCATOR_VALUES", "UTILITY_OBJECTS"};
    public static HashMap<PropertyFile, Properties> LIST_OF_ALL_PROPERTIES;
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
    public static Map<String, List<LinkedHashMap<String, String>>> excelSheetMap = new LinkedHashMap<>();
}
