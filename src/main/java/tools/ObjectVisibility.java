package tools;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import register.Data;
import register.Driver;
import register.Element;
import utilities.PropertyUtils;

public class ObjectVisibility {
    public static boolean assertVisibility(String uiObjectName, String maxWaitTime, String extraParam){
        try {
            String uiObjectDetails = PropertyUtils.getValue(uiObjectName);
            if(maxWaitTime == null){
                maxWaitTime = "NULL";
            }
            if (maxWaitTime.equals("NULL")) {
                final WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 0);
                wait.until(ExpectedConditions.visibilityOf(Element.getElement(uiObjectDetails)));
            } else if (maxWaitTime.equals("DEFAULT")) {
                final WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Data.getDefaultMaxWaitTime());
                wait.until(ExpectedConditions.visibilityOfElementLocated(Element.getElementType(uiObjectDetails)));
            } else {
                final WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Integer.parseInt(maxWaitTime));
                wait.until(ExpectedConditions.visibilityOfElementLocated(Element.getElementType(uiObjectDetails)));
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean assertInVisibility(String uiObjectName, String maxWaitTime, String extraParam){
        try {
            String uiObjectDetails = PropertyUtils.getValue(uiObjectName);
            if(maxWaitTime == null){
                maxWaitTime = "NULL";
            }
            if (maxWaitTime.equals("NULL")) {
                final WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 0);
                wait.until(ExpectedConditions.invisibilityOf(Element.getElement(uiObjectDetails)));
            } else if (maxWaitTime.equals("DEFAULT")) {
                final WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Data.getDefaultMaxWaitTime());
                wait.until(ExpectedConditions.invisibilityOfElementLocated(Element.getElementType(uiObjectDetails)));
            } else {
                final WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Integer.parseInt(maxWaitTime));
                wait.until(ExpectedConditions.invisibilityOfElementLocated(Element.getElementType(uiObjectDetails)));
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
