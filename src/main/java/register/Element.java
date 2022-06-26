package register;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.List;

public class Element {
    public static MobileElement getElement(String searchedElementString) {
        return Data.ANDROID_DRIVER.findElement(getElementType(searchedElementString));
    }
    public static List<MobileElement> getElements(String searchedElementString) {
        return Data.ANDROID_DRIVER.findElements(getElementType(searchedElementString));
    }
    public static By getElementType(String searchedElementString){
        String[] splitedElementString = searchedElementString.split("~");
        if(splitedElementString[0].trim().equals("ID")){
            return By.id(splitedElementString[1]);
        } else if(splitedElementString[0].trim().equals("XPATH")){
            return By.xpath(splitedElementString[1]);
        } else if(splitedElementString[0].trim().equals("NAME")){
            return By.name(splitedElementString[1]);
        } else if(splitedElementString[0].trim().equals("CLASSNAME")){
            return By.className(splitedElementString[1]);
        } else {
            return null;
        }
    }
}
