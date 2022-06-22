package utilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;


import java.time.Duration;
import java.util.List;

import static register.DataProvider.*;
import static register.ElementFinder.*;

public class SpecificItemSelector {

    public static void scrollToElement(String uiObjectName, String scrollBetweenElements, String relatedText, boolean untilVisible) {
        String objectsPropertyValue = UTILITY_OBJECTS.getProperty(uiObjectName);
        if(objectsPropertyValue == null){
            objectsPropertyValue = APP_LOCATOR_VALUES.getProperty(uiObjectName);
        }
        if(relatedText != null){
            objectsPropertyValue = "XPATH~"+objectsPropertyValue.split("~")[1] + relatedText + objectsPropertyValue.split("~")[2];
        }
        int i = 0;
        while (getElements(objectsPropertyValue).size() == 0){
            i++;
            if(scrollBetweenElements != null){
                scrollBetweenElements(scrollBetweenElements);
            } else {
                scrollDown();
            }
            if(i > 100){
                break;
            }
        }
        if(getElements(objectsPropertyValue).size() > 0){
            if(untilVisible){
                return;
            } else {
                getElements(objectsPropertyValue).get(0).click();
            }
        }
    }
    public static void scrollDown(){
        Dimension dimension = APPIUM_DRIVER.manage().window().getSize();

        Double scrollHeightStart = dimension.getHeight() * 0.5;
        int scrollStart = scrollHeightStart.intValue();

        Double scrollHeightEnd = dimension.getHeight() * 0.2;
        int scrollEnd = scrollHeightEnd.intValue();

        touchActionPerform(0, scrollStart, 0, scrollEnd);
    }

    public static void scrollBetweenElements(String multipleValXpaths){
        String objectsPropertyValue = UTILITY_OBJECTS.getProperty(multipleValXpaths);
        List<MobileElement> mobileElementList = getElements(objectsPropertyValue);
        MobileElement firstElement = mobileElementList.get(0);
        MobileElement lastElement = mobileElementList.get(mobileElementList.size()-1);

        int midOfYCoordinator = firstElement.getLocation().y + (firstElement.getSize().height / 2);
        int firstElementXCoordinator = firstElement.getLocation().x;
        int lastElementXCoordinator = lastElement.getLocation().x;

        touchActionPerform(lastElementXCoordinator, midOfYCoordinator, firstElementXCoordinator, midOfYCoordinator);

    }

    public static void touchActionPerform(int startX, int startY, int endX, int endY){
        new TouchAction(APPIUM_DRIVER)
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(endX, endY))
                .release().perform();
    }
}