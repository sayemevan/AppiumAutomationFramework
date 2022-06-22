package actionPerformer;

import io.appium.java_client.MobileElement;
import uiObjects.*;

import static actionPerformer.ObjectVisibility.*;
import static register.DataProvider.*;
import static register.ElementFinder.*;
import static utilities.ObjectRepositoryActions.*;

public class ObjectSpecificActions {
    public static boolean actionSet(String uiObjectName, String actionType, String valueToBeSet, String extraParam){
        try {
            String uiObjectDetails = getValue(APP_LOCATOR_VALUES, APP_LOCATOR_FILE_NAME, uiObjectName);
            if (!visibilityAssert(uiObjectName, "DEFAULT", null)) {
                return false;
            }
            MobileElement mobileElement = getElement(uiObjectDetails);
            if (uiObjectName == null || actionType == null || mobileElement == null) {
                return false;
            }
            switch (uiObjectDetails.split("~")[2].trim().toUpperCase()) {
                case "TEXTBOX":
                    TextBox textBox = new TextBox(mobileElement);
                    switch (actionType.trim().toUpperCase()) {
                        case "DEFAULT":
                        case "VALUESET":
                        case "TEXTINPUT":
                            break;
                        case "SETBLANK":
                            break;
                        case "LCLICK":
                            textBox.click();
                            break;
                        case "RCLICK":
                            break;
                        case "MOUSEOVER":
                            break;
                    }
                    break;
                case "PUSHBUTTON":
                    PushButton pushButton = new PushButton(mobileElement);
                    switch (actionType.trim().toUpperCase()) {
                        case "DEFAULT":
                        case "LCLICK":
                            pushButton.click();
                            break;
                        case "RCLICK":
                            break;
                        case "MOUSEOVER":
                            break;
                    }
                    break;
                case "ICONBUTTON":
                    IconButton iconButton = new IconButton(mobileElement);
                    switch (actionType.trim().toUpperCase()) {
                        case "DEFAULT":
                        case "LCLICK":
                            iconButton.click();
                            break;
                        case "RCLICK":
                            break;
                        case "MOUSEOVER":
                            break;
                    }
                    break;
                case "LISTBOX":
                    ListBox listBox = new ListBox(mobileElement);
                    switch (actionType.trim().toUpperCase()) {
                        case "DEFAULT":
                        case "VALUESET":
                        case "ITEMSELECT":
                            break;
                        case "ITEMDESELECT":
                        case "SETBLANK":
                            break;
                        case "TEXTINPUT":
                            break;
                        case "LCLICK":
                            listBox.click();
                            break;
                        case "RCLICK":
                            break;
                        case "MOUSEOVER":
                            break;
                    }
                    break;
                case "PREVIEW":
                    PreView preView = new PreView(mobileElement);
                    switch (actionType.trim().toUpperCase()) {
                        case "DEFAULT":
                        case "VIEW":
                            break;
                        case "LCLICK":
                            preView.click();
                            break;
                        case "RCLICK":
                            break;
                        case "MOUSEOVER":
                            break;
                    }
                    break;
                case "RADIOBUTTON":
                    RadioButton radioButton = new RadioButton(mobileElement);
                    switch (actionType.trim().toUpperCase()) {
                        case "DEFAULT":
                        case "LCLICK":
                            radioButton.click();
                            break;
                        case "RCLICK":
                            break;
                        case "SETON":
                            if(!radioButton.isEnabled()){
                                radioButton.click();
                            }
                            break;
                        case "SETOFF":
                            if(radioButton.isEnabled()){
                                radioButton.click();
                            }
                            break;
                        case "MOUSEOVER":
                            break;
                    }
                    break;
            }
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
