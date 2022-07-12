package tools;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.Keys;
import register.Data;
import register.Element;
import uiObjects.*;
import utilities.ExcelUtils;
import utilities.PropertyUtils;

public class ObjectActions {

    private static int INSTANCE_NO;

    public static boolean set(String uiObjectName, String actionType, String valueToBeSet, String extraParam){
        try {
            INSTANCE_NO = 0;
            String uiObjectDetails = PropertyUtils.getValue(uiObjectName);
            if (!ObjectVisibility.assertVisibility(uiObjectName, "DEFAULT", null)) {
                return false;
            }
            MobileElement mobileElement = Element.getElement(uiObjectDetails);
            if (uiObjectName == null || actionType == null || mobileElement == null) {
                return false;
            }
            if(valueToBeSet == null){
                valueToBeSet = "NULL";
            }

            if(extraParam != null && !extraParam.trim().equals("NULL")){
                processExtraParam(extraParam);
            }

            switch (uiObjectDetails.split("~")[2].trim().toUpperCase()) {
                case "TEXTBOX":
                    TextBox textBox = new TextBox(mobileElement);
                    switch (actionType.trim().toUpperCase()) {
                        case "DEFAULT":
                        case "VALUESET":
                        case "TEXTINPUT":
                            if (valueToBeSet.equals("BLANK") || valueToBeSet.equals("NULL")) {
                                textBox.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
                            } else {
                                textBox.sendKeys(valueToBeSet);
                            }
                            break;
                        case "SETBLANK":
                            textBox.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
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
                            listBox.click();
                            Thread.sleep(1000);
                            Scroller.scrollToElementByText(valueToBeSet, INSTANCE_NO);
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
                case "LISTVIEW":
                    ListView listView = new ListView(mobileElement);
                    switch (actionType.trim().toUpperCase()) {
                        case "DEFAULT":
                        case "LCLICK":
                            listView.click();
                            break;
                        case "RCLICK":
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

    public static boolean setGroupAction(String sheetName, String extraParam) {
        try {
            String uiObjectName, actionType, valueToBeSet, extraActionIndicator;
            Data.getExcelSheetMap().put(sheetName, ExcelUtils.getData(Data.EXCEL_SHEET_FILE_NAME, Data.EXCEL_SHEET_FILE_PATH, sheetName));
            for (int j = 0; j < Data.getExcelSheetMap().get(sheetName).size(); j++) {
                uiObjectName = Data.getExcelSheetMap().get(sheetName).get(j).get("UiObjectName");
                actionType = Data.getExcelSheetMap().get(sheetName).get(j).get("ActionType");
                valueToBeSet = Data.getExcelSheetMap().get(sheetName).get(j).get("ValueToBeSet");
                extraActionIndicator = Data.getExcelSheetMap().get(sheetName).get(j).get("ExtraActionIndicator");

                valueToBeSet = checkDoubleQuotes(valueToBeSet);
                extraActionIndicator = checkDoubleQuotes(extraActionIndicator);

                Scroller.scrollUntilElementVisible(uiObjectName, null, 0);
                set(uiObjectName, actionType, valueToBeSet, extraActionIndicator);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static String checkDoubleQuotes(String valueToCheck){
        if(valueToCheck.startsWith("\"") && valueToCheck.endsWith("\"")){
            return valueToCheck.substring(1, valueToCheck.length()-1);
        }
        return valueToCheck;
    }

    private static void processExtraParam(String extraParam){
        String extraActions[] = extraParam.trim().split("\\|");
        for(String extraAction: extraActions){
            switch (extraAction.trim().split(":")[0].trim()){
                case "INSTANCENO":
                    INSTANCE_NO = Integer.parseInt(extraAction.trim().split(":")[1].trim()) - 1;
                    break;
            }
        }
    }
}
