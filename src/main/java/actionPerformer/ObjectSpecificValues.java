package actionPerformer;

import io.appium.java_client.MobileElement;
import uiObjects.*;

import static actionPerformer.ObjectVisibility.visibilityAssert;
import static register.ElementFinder.getElement;
import static utilities.ObjectRepositoryActions.getRepoValue;
import static utilities.OnPageElementScroller.scrollUntilElementVisible;

public class ObjectSpecificValues {
    public static String valueGet(String uiObjectName, String propertyName, String extraParam){
        try {
            String outputValue = "", uiObjectDetails = getRepoValue(uiObjectName);
            if (!visibilityAssert(uiObjectName, "DEFAULT", null)) {
                return outputValue;
            }
            MobileElement mobileElement = getElement(uiObjectDetails);
            if (uiObjectName == null || propertyName == null || mobileElement == null || propertyName == null) {
                return outputValue;
            }

            switch (uiObjectDetails.split("~")[2].trim().toUpperCase()) {
                case "TEXTBOX":
                    TextBox textBox = new TextBox(mobileElement);
                    outputValue = propertyNameExtractor(propertyName, textBox);
                    break;
                case "PUSHBUTTON":
                    PushButton pushButton = new PushButton(mobileElement);
                    outputValue = propertyNameExtractor(propertyName, pushButton);
                    break;
                case "ICONBUTTON":
                    IconButton iconButton = new IconButton(mobileElement);
                    outputValue = propertyNameExtractor(propertyName, iconButton);
                    break;
                case "LISTBOX":
                    ListBox listBox = new ListBox(mobileElement);
                    outputValue = propertyNameExtractor(propertyName, listBox);
                    break;
                case "PREVIEW":
                    PreView preView = new PreView(mobileElement);
                    outputValue = propertyNameExtractor(propertyName, preView);
                    break;
                case "RADIOBUTTON":
                    RadioButton radioButton = new RadioButton(mobileElement);
                    outputValue = propertyNameExtractor(propertyName, radioButton);
                    break;
                case "LISTVIEW":
                    ListView listView = new ListView(mobileElement);
                    outputValue = propertyNameExtractor(propertyName, listView);
                    break;
            }
            return outputValue;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    private static String propertyNameExtractor(String propertyName, MobileElement mobileElement) {
        String outputValue = "";
        switch (propertyName.trim().toUpperCase()) {
            case "DEFAULT":
            case "CURRTEXT":
            case "CURRVAL":
                outputValue = mobileElement.getText();
                break;
            case "OBJWIDTH":
                outputValue = String.valueOf(mobileElement.getSize().getWidth());
                break;
            case "OBJHEIGHT":
                outputValue = String.valueOf(mobileElement.getSize().getHeight());
                break;
            case "OBJLABEL":
                break;
            case "XCOORD":
                outputValue = String.valueOf(mobileElement.getLocation().getX());
                break;
            case "YCOORD":
                outputValue = String.valueOf(mobileElement.getLocation().getY());
                break;
            case "WRNLABEL":
                break;
        }
        return outputValue;
    }
}
