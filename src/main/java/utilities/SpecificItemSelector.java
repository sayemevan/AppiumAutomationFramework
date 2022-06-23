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
import static utilities.ObjectRepositoryActions.*;

public class SpecificItemSelector {

    public static void scrollUntilElementVisible(String uiObjectName, String elementNameForScrollBetween){
        String objectsPropertyValue = getRepoValue(uiObjectName);
        int i = 0;
        while (getElements(objectsPropertyValue).size() == 0){
            i++;
            scrolling(elementNameForScrollBetween);
            if(i > 100){
                break;
            }
        }
    }

    public static void scrollToElement(String uiObjectName, String elementNameForScrollBetween){
        String objectsPropertyValue = getRepoValue(uiObjectName);
        int i = 0;
        while (getElements(objectsPropertyValue).size() == 0){
            i++;
            scrolling(elementNameForScrollBetween);
            if(i > 100){
                break;
            }
        }
        if(getElements(objectsPropertyValue).size() > 0){
            getElements(objectsPropertyValue).get(0).click();
        }
    }

    public static void dynamicScrollToElement(String uiObjectName, String elementNameForScrollBetween, String dynamicText){
        String objectsPropertyValue = getRepoValue(uiObjectName);
        if(dynamicText != null){
            objectsPropertyValue = "XPATH~"+objectsPropertyValue.split("~")[1] + dynamicText + objectsPropertyValue.split("~")[2];
        }
        int i = 0;
        while (getElements(objectsPropertyValue).size() == 0){
            i++;
            scrolling(elementNameForScrollBetween);
            if(i > 100){
                break;
            }
        }
        if(getElements(objectsPropertyValue).size() > 0){
            getElements(objectsPropertyValue).get(0).click();
        }
    }

    public static void scrolling(String betweenElements){
        if(betweenElements != null){
            scrollBetweenElements(betweenElements);
        } else {
            scrollDown();
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
        String objectsPropertyValue = getRepoValue(multipleValXpaths);
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