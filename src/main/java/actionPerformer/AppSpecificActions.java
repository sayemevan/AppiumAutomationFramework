package actionPerformer;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppSpecificActions {
    public static AppiumDriver<MobileElement> appiumDriver;
    public static String path;
    public static boolean LunchApp(){
        try {
            path = System.getProperty("user.dir");
            DesiredCapabilities desCap = new DesiredCapabilities();

            //device information
            desCap.setCapability("platformName", "Android");
            desCap.setCapability("deviceName", "emulator-5554");
            //app inforamtion
            desCap.setCapability("app", path + "//src//test//resources//app//nopstationCart.apk");
            desCap.setCapability("appPackage", "com.nopstation.nopcommerce.nopstationcart");
            desCap.setCapability("appActivity", "com.bs.ecommerce.main.SplashScreenActivity");

            appiumDriver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desCap);
            appiumDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            System.out.println("App lunched!");
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
