package actionPerformer;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static register.DataProvider.*;
import static register.ElementFinder.*;
import static utilities.ObjectRepositoryActions.*;

public class ObjectVisibility {
    public static boolean visibilityAssert(String uiObjectName, String maxWaitTime, String extraParam){
        try {
            String uiObjectDetails = getRepoValue(uiObjectName);
            if(maxWaitTime == null){
                maxWaitTime = "NULL";
            }
            if (maxWaitTime.equals("NULL")) {
                final WebDriverWait wait = new WebDriverWait(APPIUM_DRIVER, 0);
                wait.until(ExpectedConditions.visibilityOf(getElement(uiObjectDetails)));
            } else if (maxWaitTime.equals("DEFAULT")) {
                final WebDriverWait wait = new WebDriverWait(APPIUM_DRIVER, MAX_WAIT_TIME);
                wait.until(ExpectedConditions.visibilityOfElementLocated(getSpecificElementType(uiObjectDetails)));
            } else {
                final WebDriverWait wait = new WebDriverWait(APPIUM_DRIVER, Integer.parseInt(maxWaitTime));
                wait.until(ExpectedConditions.visibilityOfElementLocated(getSpecificElementType(uiObjectDetails)));
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean inVisibilityAssert(String uiObjectName, String maxWaitTime, String extraParam){
        try {
            String uiObjectDetails = getRepoValue(uiObjectName);
            if(maxWaitTime == null){
                maxWaitTime = "NULL";
            }
            if (maxWaitTime.equals("NULL")) {
                final WebDriverWait wait = new WebDriverWait(APPIUM_DRIVER, 0);
                wait.until(ExpectedConditions.invisibilityOf(getElement(uiObjectDetails)));
            } else if (maxWaitTime.equals("DEFAULT")) {
                final WebDriverWait wait = new WebDriverWait(APPIUM_DRIVER, MAX_WAIT_TIME);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(getSpecificElementType(uiObjectDetails)));
            } else {
                final WebDriverWait wait = new WebDriverWait(APPIUM_DRIVER, Integer.parseInt(maxWaitTime));
                wait.until(ExpectedConditions.invisibilityOfElementLocated(getSpecificElementType(uiObjectDetails)));
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
