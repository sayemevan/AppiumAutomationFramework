package tools;

import io.appium.java_client.MobileElement;
import register.Element;
import uiObjects.*;
import utilities.PropertyUtils;

public class ObjectValues {
    public static String get(String uiObjectName, String propertyName, String extraParam){
        try {
            String outputValue = "", uiObjectDetails = PropertyUtils.getValue(uiObjectName);
            if (!ObjectVisibility.assertVisibility(uiObjectName, "DEFAULT", null)) {
                return outputValue;
            }
            MobileElement mobileElement = Element.getElement(uiObjectDetails);
            if (uiObjectName == null || propertyName == null || mobileElement == null || propertyName == null) {
                return outputValue;
            }

            switch (uiObjectDetails.split("~")[2].trim().toUpperCase()) {
                case "TEXTBOX":
                    TextBox textBox = new TextBox(mobileElement);
                    outputValue = extractPropertyName(propertyName, textBox);
                    break;
                case "PUSHBUTTON":
                    PushButton pushButton = new PushButton(mobileElement);
                    outputValue = extractPropertyName(propertyName, pushButton);
                    break;
                case "ICONBUTTON":
                    IconButton iconButton = new IconButton(mobileElement);
                    outputValue = extractPropertyName(propertyName, iconButton);
                    break;
                case "LISTBOX":
                    ListBox listBox = new ListBox(mobileElement);
                    outputValue = extractPropertyName(propertyName, listBox);
                    break;
                case "PREVIEW":
                    PreView preView = new PreView(mobileElement);
                    outputValue = extractPropertyName(propertyName, preView);
                    break;
                case "RADIOBUTTON":
                    RadioButton radioButton = new RadioButton(mobileElement);
                    outputValue = extractPropertyName(propertyName, radioButton);
                    break;
                case "LISTVIEW":
                    ListView listView = new ListView(mobileElement);
                    outputValue = extractPropertyName(propertyName, listView);
                    break;
            }
            return outputValue;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    private static String extractPropertyName(String propertyName, MobileElement mobileElement) {
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
