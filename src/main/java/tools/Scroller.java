package tools;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import register.Data;
import register.Driver;
import register.Element;
import utilities.PropertyUtils;


import java.time.Duration;
import java.util.List;

public class Scroller {

    public static void scrollUntilElementVisible(String uiObjectName, String elementNameForScrollBetween, int maxTimeInSecOfScrolling){
        String objectsPropertyValue = PropertyUtils.getValue(uiObjectName);
        scrollWithTime(objectsPropertyValue, elementNameForScrollBetween, maxTimeInSecOfScrolling);
    }

    public static void scrollToElementAndClick(String uiObjectName, String elementNameForScrollBetween, int maxTimeInSecOfScrolling){
        String objectsPropertyValue = PropertyUtils.getValue(uiObjectName);
        scrollWithTime(objectsPropertyValue, elementNameForScrollBetween, maxTimeInSecOfScrolling);
        if(Element.getElements(objectsPropertyValue).size() > 0){
            Element.getElements(objectsPropertyValue).get(0).click();
        }
    }

    public static void dynamicScrollToElementAndClick(String uiObjectName, String elementNameForScrollBetween, String dynamicText, int maxTimeInSecOfScrolling){
        String objectsPropertyValue = PropertyUtils.getValue(uiObjectName);
        if(dynamicText != null){
            objectsPropertyValue = "XPATH~"+objectsPropertyValue.split("~")[1] + dynamicText + objectsPropertyValue.split("~")[2];
        }
        scrollWithTime(objectsPropertyValue, elementNameForScrollBetween, maxTimeInSecOfScrolling);
        if(Element.getElements(objectsPropertyValue).size() > 0){
            Element.getElements(objectsPropertyValue).get(0).click();
        }
    }

    public static void scrollToElementByText(String searchedText, int instanceNo){
        Driver.getDriver().findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""
                        + searchedText + "\").instance("+ instanceNo +"))").click();
    }

    public static void scrollDown(int scrollAmount){
        int amountOfscroll = 1, scrollStart, scrollEnd;
        Dimension dimension;
        double scrollHeightStart, scrollHeightEnd;
        if(scrollAmount > 1){
            amountOfscroll = scrollAmount;
        }
        for(int i = 0; i < amountOfscroll; i++) {
            dimension = Driver.getDriver().manage().window().getSize();
            scrollHeightStart = dimension.getHeight() * 0.5;
            scrollStart = (int) scrollHeightStart;
            scrollHeightEnd = dimension.getHeight() * 0.2;
            scrollEnd = (int) scrollHeightEnd;

            touchActionPerform(0, scrollStart, 0, scrollEnd);
        }
    }

    public static void scrollBetweenElements(String multipleValXpaths){
        MobileElement firstElement, lastElement;
        int midOfYCoordinator, firstElementXCoordinator, lastElementXCoordinator;

        String objectsPropertyValue = PropertyUtils.getValue(multipleValXpaths);
        List<MobileElement> mobileElementList = Element.getElements(objectsPropertyValue);
        firstElement = mobileElementList.get(0);
        lastElement = mobileElementList.get(mobileElementList.size()-1);

        midOfYCoordinator = firstElement.getLocation().y + (firstElement.getSize().height / 2);
        firstElementXCoordinator = firstElement.getLocation().x;
        lastElementXCoordinator = lastElement.getLocation().x;

        touchActionPerform(lastElementXCoordinator, midOfYCoordinator, firstElementXCoordinator, midOfYCoordinator);

    }

    public static void touchActionPerform(int startX, int startY, int endX, int endY){
        new TouchAction(Driver.getDriver())
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(endX, endY))
                .release().perform();
    }

    private static long scrollMethodTimeCount(int maxTimeInSecOfScrolling){
        long waitTime = Data.DEFAULT_MAX_WAIT_TIME * 1000;
        if(maxTimeInSecOfScrolling > 0){
            waitTime = maxTimeInSecOfScrolling * 1000;
        }
        return waitTime;
    }

    private static void scrollWithTime(String objectsPropertyValue, String elementNameForScrollBetween, int maxTimeInSecOfScrolling){
        long startTime, endTime;
        startTime = System.currentTimeMillis();
        endTime = startTime + scrollMethodTimeCount(maxTimeInSecOfScrolling);
        while (Element.getElements(objectsPropertyValue).size() == 0){
            scrolling(elementNameForScrollBetween);
            if(System.currentTimeMillis() > endTime){
                break;
            }
        }
    }

    private static void scrolling(String betweenElements){
        if(betweenElements != null){
            scrollBetweenElements(betweenElements);
        } else {
            scrollDown(1);
        }
    }
}