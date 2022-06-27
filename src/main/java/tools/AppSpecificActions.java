package tools;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import register.Data;
import register.Driver;
import register.PropertyFile;
import utilities.PropertyUtils;

import java.net.URL;

public class AppSpecificActions {
    public static void lunchApp(){
        try {
            loadPrimaryData();

            DesiredCapabilities desCap = new DesiredCapabilities();
            //device information
            desCap.setCapability("platformName", Data.getPlatformName());
            desCap.setCapability("deviceName", Data.getDeviceName());
            //app inforamtion
            desCap.setCapability("app", Data.getAPP());
            desCap.setCapability("appPackage", Data.getAppPackage());
            desCap.setCapability("appActivity", Data.getAppActivity());

            //Driver initialize
            new Driver(new AndroidDriver<>(new URL(Data.getAppiumServerUrl()), desCap));

            System.out.println("App lunched!");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void closeApp() {
        Driver.getDriver().closeApp();
    }

    public static void loadPrimaryData(){
        try {
            Data.getListOfAllProperties().put(PropertyFile.APP_LOCATOR_VALUES, PropertyUtils.getProperties(Data.getAppLocatorPath(), Data.getAppLocatorFileName()));
            Data.getListOfAllProperties().put(PropertyFile.UTILITY_OBJECTS, PropertyUtils.getProperties(Data.getAppLocatorPath(), Data.getUtilityObjectsFileName()));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
