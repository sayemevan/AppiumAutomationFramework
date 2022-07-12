package register;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Driver {
    private static AndroidDriver<MobileElement> ANDROID_DRIVER;

    public Driver(AndroidDriver<MobileElement> ANDROID_DRIVER){
        this.ANDROID_DRIVER = ANDROID_DRIVER;
    }

    public static AndroidDriver<MobileElement> getDriver(){
        return ANDROID_DRIVER;
    }
}
