package tools;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import register.Data;
import register.PropertyFile;
import utilities.PropertyUtils;

import java.net.URL;

public class AppSpecificActions {
    public static void lunchApp(){
        try {
            loadPrimaryData();

            DesiredCapabilities desCap = new DesiredCapabilities();
            //device information
            desCap.setCapability("platformName", Data.PLATFORM_NAME);
            desCap.setCapability("deviceName", Data.DEVICE_NAME);
            //app inforamtion
            desCap.setCapability("app", Data.APP);
            desCap.setCapability("appPackage", Data.APP_PACKAGE);
            desCap.setCapability("appActivity", Data.APP_ACTIVITY);

            Data.ANDROID_DRIVER = new AndroidDriver<MobileElement>(new URL(Data.APPIUM_SERVER_URL), desCap);
            System.out.println("App lunched!");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void closeApp() {
        Data.ANDROID_DRIVER.closeApp();
    }

    public static void loadPrimaryData(){
        Data.LIST_OF_ALL_PROPERTIES.put(PropertyFile.APP_LOCATOR_VALUES, PropertyUtils.getProperties(Data.APP_LOCATOR_PATH, Data.APP_LOCATOR_FILE_NAME));
        Data.LIST_OF_ALL_PROPERTIES.put(PropertyFile.UTILITY_OBJECTS, PropertyUtils.getProperties(Data.APP_LOCATOR_PATH, Data.UTILITY_OBJECTS_FILE_NAME));
    }
}
