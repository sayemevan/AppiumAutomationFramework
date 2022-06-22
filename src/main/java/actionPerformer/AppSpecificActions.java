package actionPerformer;

import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

import static dataProvider.propertyFileReader.*;
import static register.DataProvider.*;

public class AppSpecificActions {
    public static void lunchApp(){
        try {
            loadPrimaryDatas();

            DesiredCapabilities desCap = new DesiredCapabilities();
            //device information
            desCap.setCapability("platformName", PLATFORM_NAME);
            desCap.setCapability("deviceName", DEVICE_NAME);
            //app inforamtion
            desCap.setCapability("app", APP);
            desCap.setCapability("appPackage", APP_PACKAGE);
            desCap.setCapability("appActivity", APP_ACTIVITY);

            APPIUM_DRIVER = new AndroidDriver<MobileElement>(new URL(APPIUM_SERVER_URL), desCap);
            System.out.println("App lunched!");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void closeApp() {
        APPIUM_DRIVER.closeApp();
    }

    public static void loadPrimaryDatas(){
        APP_LOCATOR_VALUES = objectRepositoryGet(APP_LOCATOR_PATH, APP_LOCATOR_FILE_NAME);
        UTILITY_OBJECTS = objectRepositoryGet(APP_LOCATOR_PATH, UTILITY_OBJECTS_FILE_NAME);
    }
}
